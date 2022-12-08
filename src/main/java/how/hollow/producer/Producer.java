/*
 *
 *  Copyright 2016 Netflix, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */
package how.hollow.producer;

import com.netflix.hollow.api.consumer.HollowConsumer.AnnouncementWatcher;
import com.netflix.hollow.api.consumer.HollowConsumer.BlobRetriever;
import com.netflix.hollow.api.consumer.fs.HollowFilesystemAnnouncementWatcher;
import com.netflix.hollow.api.consumer.fs.HollowFilesystemBlobRetriever;
import com.netflix.hollow.api.producer.HollowProducer;
import com.netflix.hollow.api.producer.HollowProducer.Announcer;
import com.netflix.hollow.api.producer.HollowProducer.Publisher;
import com.netflix.hollow.api.producer.fs.HollowFilesystemAnnouncer;
import com.netflix.hollow.api.producer.fs.HollowFilesystemPublisher;
import how.hollow.producer.domain.adstxt.AdsTxtEntryDTO;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;


public class Producer implements Runnable {
    
    public static final String SCRATCH_DIR = System.getProperty("java.io.tmpdir");
    private static final long MIN_TIME_BETWEEN_CYCLES = 10000;
    public static final String USER_NAME = "admin";
    public static final String PASSWORD = System.getenv("producer.password");
    public static final String URL_DATA_DATASETS = "https://lga-kube-data-service-lighttpd.pulsepoint.com/DataService/services/data/datasets/";
    private final File publishDir;
    private final String datasetName;
    private final Function<String[], Object> mapper;

    static {
        final String password;
        if (PASSWORD == null || PASSWORD.isEmpty()) {
            System.out.println("Enter password for " + USER_NAME + ": ");
            password = new Scanner(System.in).nextLine();
        } else {
            password = PASSWORD;
        }
        Authenticator.setDefault(
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {

                        return new PasswordAuthentication(USER_NAME, password.toCharArray());
                    }
                });
    }

    public Producer(File publishDir, String datasetName, Function<String[], Object> mapper) {

        this.publishDir = publishDir;
        this.datasetName = datasetName;
        this.mapper = mapper;
    }

    public static void main(String[] args) throws Exception {

        CompletableFuture<Void> adstxtCrawlerEntries = CompletableFuture.runAsync(
                new Producer(new File(SCRATCH_DIR, "publish-dir"), "adstxt_crawler_entries", Producer::mappingAdsTxtEntryDTO)
        );

        CompletableFuture<Void> appadstxtCrawlerEntries = CompletableFuture.runAsync(
                new Producer(new File(SCRATCH_DIR, "publish-dir-app"), "appadstxt_crawler_entries", Producer::mappingAdsTxtEntryDTO)
        );

        CompletableFuture.allOf(adstxtCrawlerEntries, appadstxtCrawlerEntries).join();
    }

    public void run() {
        publishDir.mkdir();
        System.out.println("I AM THE PRODUCER.  I WILL PUBLISH TO " + publishDir.getAbsolutePath());

        Publisher publisher = new HollowFilesystemPublisher(publishDir.toPath());
        Announcer announcer = new HollowFilesystemAnnouncer(publishDir.toPath());

        BlobRetriever blobRetriever = new HollowFilesystemBlobRetriever(publishDir.toPath());
        AnnouncementWatcher announcementWatcher = new HollowFilesystemAnnouncementWatcher(publishDir.toPath());

        HollowProducer producer = HollowProducer.withPublisher(publisher)
                .withAnnouncer(announcer)
                .build();

        producer.initializeDataModel(AdsTxtEntryDTO.class);

        restoreIfAvailable(producer, blobRetriever, announcementWatcher);

        startPublishing(producer, datasetName, mapper);
    }

    public static void restoreIfAvailable(HollowProducer producer,
            BlobRetriever retriever,
            AnnouncementWatcher unpinnableAnnouncementWatcher) {

        System.out.println("ATTEMPTING TO RESTORE PRIOR STATE...");
        long latestVersion = unpinnableAnnouncementWatcher.getLatestVersion();
        if(latestVersion != AnnouncementWatcher.NO_ANNOUNCEMENT_AVAILABLE) {
            producer.restore(latestVersion, retriever);
            System.out.println("RESTORED " + latestVersion);
        } else {
            System.out.println("RESTORE NOT AVAILABLE");
        }
    }


    public void startPublishing(HollowProducer producer, String datasetName, Function<String[], Object> mapper) {
        Path filePath = Path.of(publishDir.getAbsolutePath(), datasetName + ".txt");
        if (!filePath.toFile().exists()) {
            downloadTo(datasetName, filePath);
        }

        long lastCycleTime = Long.MIN_VALUE;
        while(true) {
            waitForMinCycleTime(lastCycleTime);
            lastCycleTime = System.currentTimeMillis();
            producer.runCycle(writeState -> {
                Files.readAllLines(filePath).stream()
                        .skip(1)
                        .map(line -> line.split("\\s"))
                        .map(mapper)
                        .forEach(writeState::add);
            });
        }
    }

    private static void downloadTo(String datasetName, Path filePath) {
        System.out.println("Download " + datasetName + "...");
        try {
            FileUtils.copyURLToFile(
                    new URL(URL_DATA_DATASETS + datasetName),
                    filePath.toFile()
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Done!");
    }

    private static AdsTxtEntryDTO mappingAdsTxtEntryDTO(String[] split) {
        return new AdsTxtEntryDTO(split[0], split[2], split[3]);
    }

    private static void waitForMinCycleTime(long lastCycleTime) {
        long targetNextCycleTime = lastCycleTime + MIN_TIME_BETWEEN_CYCLES;

        while(System.currentTimeMillis() < targetNextCycleTime) {
            try {
                Thread.sleep(targetNextCycleTime - System.currentTimeMillis());
            } catch(InterruptedException ignore) { }
        }
    }

}
