package com.vt.rtqs;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vt.rtqs.model.Quotation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;


import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ExecutionException;

@Profile("producer")
@RestController
@RequestMapping("/api/producer")
public class KafkaRestAPI {

    @Value(value = "${spring.kafka.properties.bootstrap.servers}")
    private String bootstrapAddress;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping
    @Tag(name="publish", description = "Publish Quotation to a topic")
    public String publish(@RequestParam String topic, @RequestBody Quotation msg) throws JsonProcessingException {
//        System.out.println(topic + msg);
        ObjectMapper objectMapper = new ObjectMapper();
        String msgStr = objectMapper.writeValueAsString(msg);
        kafkaTemplate.send(topic, msgStr);

        return "Msg Sent: "+msg;
    }

    @GetMapping
    @Tag(name="topics", description = "Get all topics present to connected cluster")
    public Set<String> topics() throws ExecutionException, InterruptedException {
        Properties properties = new Properties();
        properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);

        AdminClient adminClient = KafkaAdminClient.create(properties);

        return adminClient.listTopics().names().get();
    }
}
