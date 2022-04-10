package com.vt.rtqs.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("consumer")
public class KafkaConsumer {

    @Value(value = "${kafka.topics}")
    private List<String> topics;

    @KafkaListener(id = "rtqs", topics = "#{'${kafka.topics}'.split(',')}")
    public void listen(String in) {
        System.out.println("recieved :"+ in);
    }
}

