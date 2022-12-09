# hollow-poc
Proof of concept for hollow project https://hollow.how/

# Build 

```bash 
mvn clean package
```

# How to run 

There are `Producer.java` and `Consumer.java`, both have a main method. You have to run them both (the order doesn't matter)
Producer will download one of our datasets from https://lga-kube-data-service-lighttpd.pulsepoint.com for it will ask you to enter the password from `admin` user. 
Or you can set env variable `producer.password` or just put it [here](https://github.com/pulsepointinc/hollow-poc/blob/master/src/main/java/how/hollow/producer/Producer.java#L49) as a static String. 

* **Producer** is an example how our future httpd might be 
* **Consumer** is an example how our application that needs a dataset will look like.  
