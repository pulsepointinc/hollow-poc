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
package how.hollow.consumer;

import com.netflix.hollow.api.consumer.HollowConsumer;
import com.netflix.hollow.api.consumer.fs.HollowFilesystemAnnouncementWatcher;
import com.netflix.hollow.api.consumer.fs.HollowFilesystemBlobRetriever;
import com.netflix.hollow.api.consumer.index.HashIndex;
import com.netflix.hollow.core.read.engine.HollowReadStateEngine;
import com.netflix.hollow.core.read.engine.HollowTypeReadState;
import com.netflix.hollow.explorer.ui.jetty.HollowExplorerUIServer;
import com.netflix.hollow.history.ui.jetty.HollowHistoryUIServer;
import how.hollow.consumer.api.generated.AdsTxtEntryDTO;
import how.hollow.consumer.api.generated.DomainSetsApi;

import java.io.File;

public class Consumer {

    public static final String SCRATCH_DIR = System.getProperty("java.io.tmpdir");
    
    
    public static void main(String args[]) throws Exception {
        HollowConsumer consumer = startConsumer(new File(SCRATCH_DIR, "publish-dir"), "019agora.com.br");
        HollowConsumer consumerApp = startConsumer(new File(SCRATCH_DIR, "publish-dir-app"), "wcyb.com");

        /// start a history server on port 7777
        HollowHistoryUIServer historyServer = new HollowHistoryUIServer(consumer, 7777);
        historyServer.start();

        /// start an explorer server on port 7778
        HollowExplorerUIServer explorerServer = new HollowExplorerUIServer(consumer, 7778);
        explorerServer.start();


        /// start a history server on port 7779
        HollowHistoryUIServer historyServerApp = new HollowHistoryUIServer(consumerApp, 7779);
        historyServerApp.start();

        /// start an explorer server on port 7780
        HollowExplorerUIServer explorerServerApp = new HollowExplorerUIServer(consumerApp, 7780);
        explorerServerApp.start();

        historyServer.join();
    }

    private static HollowConsumer startConsumer(File publishDir, String exampleQueryElement) {
        System.out.println("I AM THE CONSUMER.  I WILL READ FROM " + publishDir.getAbsolutePath());

        HollowConsumer.BlobRetriever blobRetriever = new HollowFilesystemBlobRetriever(publishDir.toPath());
        HollowConsumer.AnnouncementWatcher announcementWatcher = new HollowFilesystemAnnouncementWatcher(publishDir.toPath());

        HollowConsumer consumer = HollowConsumer.withBlobRetriever(blobRetriever)
                                                .withAnnouncementWatcher(announcementWatcher)
                                                .withGeneratedAPIClass(DomainSetsApi.class)
                                                .build();

        consumer.triggerRefresh();

        HashIndex<AdsTxtEntryDTO, String> findByDomain = HashIndex.from(consumer, AdsTxtEntryDTO.class)
            .usingPath("domain.value", String.class);

        findByDomain.findMatches(exampleQueryElement).forEach(adsTxtEntryDTO -> {
            System.out.println("From " + adsTxtEntryDTO.toString());
        });

        System.out.println("Total memory read from " + publishDir.getName() + ": " + memStat(consumer));
        return consumer;
    }

    public static long memStat(HollowConsumer consumer) {
        HollowReadStateEngine stateEngine = consumer.getStateEngine();

        long totalApproximateHeapFootprint = 0;

        for(HollowTypeReadState typeState : stateEngine.getTypeStates()) {
            String typeName = typeState.getSchema().getName();
            long heapCost = typeState.getApproximateHeapFootprintInBytes();
            System.out.println(typeName + ": " + heapCost);
            totalApproximateHeapFootprint += heapCost;
        }

        return totalApproximateHeapFootprint;
    }

}
