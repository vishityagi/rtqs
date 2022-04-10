package com.vt.rtqs;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class RtqsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RtqsApplication.class, args);
	}

}
