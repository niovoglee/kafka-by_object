package com.niovo.niovokafka.config;

import com.niovo.niovokafka.util.AppConstants;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

import static com.niovo.niovokafka.util.AppConstants.TOPIC_NAME_TASK;

@Configuration
public class KafkaConfig {

//    @Value(value = "${kafka.bootstrapServers:localhost:9092}")
//    private String bootstrapServers;
//
//    @Bean
//    public KafkaAdmin kafkaAdmin() {
//        Map<String, Object> configs = new HashMap<>();
//        // Depending on you Kafka Cluster setup you need to configure
//        // additional properties!
//        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
//        return new KafkaAdmin(configs);
//    }


    @Bean
    public NewTopic niovoTaskTopic() {

        return TopicBuilder.name(TOPIC_NAME_TASK)
                .build();
    }
//    @Bean
//    public NewTopic niovoLeaveTopic(){
//        return TopicBuilder.name(AppConstants.TOPIC_NAME_LEAVE)
//                .build();
//    }
//    @Bean
//    public NewTopic niovoTopic() {
//        return TopicBuilder.name("niovo_topic")
//                .partitions(6)
//                .replicas(1)
//                .config(TopicConfig.COMPRESSION_TYPE_CONFIG, "gzip")
//                .build();
//    }
}
