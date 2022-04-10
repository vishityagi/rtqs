# Kafka Producer and Consumer App

### Reference Documentation
This is a spring boot app that uses spring-kafka to connect to Apache kafka cluster on Confluent cloud,
to produce and consume quotations for tickers.

Motivation behind using kafka is:
* I have been working on exploring Kafka recently
* Kafka uses a binary protocol over TCP, which was the ask.

There are many ways to achieve this, but for demonstration I have used the simplest setup.
Quotation class is our object that is being produced as string and consumed as string.

Kafka topics are configured in properties with key : "kafka.topics" which ensures that consumers can subscribe to topics as and when required
* [Official Spring-Kafka documentation for other kafka properties](https://docs.spring.io/spring-kafka/reference/html/#reference)

There are many more properties and features from spring-kafka that have not been utilised in this demo app, as they were not mentioned as requirements.
Like configuring offsets policy, partitions in case of multiple consumers of same group, creating new topic programmatically etc. 

To run this app locally, one needs to have access to confluent cloud.
For this demo I have added api keys to my properties, which otherwise should be encrypted and stored elsewhere.

### To run this app:
* Install java11 or higher (This was created and tested with Java-17.00.1)
* Run it as Spring boot app in any IDA with spring profiles: "producer" or "consumer" or both.
* If "producer profile is active", you can check the REST endpoints available at: http://localhost:8080/swagger-ui/index.html#
![image](https://user-images.githubusercontent.com/13507690/162608370-ab6a3867-d76d-4373-9ea2-ed9cc7af3181.png)
* This app can run with different profile on different machines to achieve the same producer/consumer msg flow.
* To Add new topics for cluster the change needs to be done manually at kafka cluster.

### Alternate flow:
Currently I am using seperate topics for all tickers as the requirement said the consumer should be able to subscribe as required. But we could also use a single topic for all ticker and filter at consumer level based on keys or by using k-stream filters.

## NEXT STEPS
Here I have represented simple producer/consumer sever side apps. I was not clear on eact requirements so I assumed this is what was required. Incase we need a client (As in front end app) to read these msgs real time, we can implement the same using webflux websockets to provide a websocket in spring boot consumer for our front end app. I did a personal project on it once, but Haven't used it in production.
 
    
