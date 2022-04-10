//package com.vt.rtqs.config;
//
//import org.apache.kafka.clients.admin.Admin;
//import org.apache.kafka.clients.admin.AdminClientConfig;
//import org.apache.kafka.clients.admin.KafkaAdminClient;
//import org.apache.kafka.clients.admin.NewTopic;
//import org.springframework.beans.BeansException;
//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.beans.factory.BeanFactoryAware;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.core.KafkaAdmin;
//
//import javax.annotation.PostConstruct;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.Properties;
//
//@Configuration
//public class KafkaTopicConfig implements BeanFactoryAware {
//
//    @Value(value = "${spring.kafka.properties.bootstrap.servers}")
//    private String bootstrapAddress;
//
//    @Value(value = "${kafka.topics}")
//    private List<String> topics;
//
//    @Bean
//    public KafkaAdmin kafkaAdmin() {
//        Map<String, Object> configs = new HashMap<>();
//        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
//        return new KafkaAdmin(configs);
//    }
//
//
////    @Bean
////    public NewTopic topic1() {
////        return new NewTopic("baeldung", 1, (short) 1);
////    }
//
//    private BeanFactory beanFactory;
//
//    @Override
//    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
//            this.beanFactory = beanFactory;
//        }
//
//
//    @PostConstruct
//    public void onPostConstruct() {
//        ConfigurableBeanFactory configurableBeanFactory = (ConfigurableBeanFactory) beanFactory;
//        for (String topic : topics) {
//            // setup beans programmatically
//            String beanName= topic;
//            Object bean = new NewTopic(topic, 1, (short) 1);
//            configurableBeanFactory.registerSingleton(beanName, bean);
//        }
//    }
//}
