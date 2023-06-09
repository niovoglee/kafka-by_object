package com.niovo.niovokafka.service;

import com.google.gson.Gson;
import com.niovo.niovokafka.dto.User;
import com.niovo.niovokafka.dto.tesk.TaskInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final Gson gson;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate, Gson gson) {

        this.kafkaTemplate = kafkaTemplate;
        this.gson = gson;
    }

    public void sendUserMessage(User user, String topic) {

        log.info(String.format("1. Produce %s Message sent -> %s", topic, user.toString()));

        Message<User> userKafka = MessageBuilder
                .withPayload(user)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();
        kafkaTemplate.send(userKafka);
    }

    public void sendTaskMessage(TaskInput taskInput, String topic) {

        log.info(String.format("2. Produce %s Message sent -> %s", topic, taskInput.toString()));

        Message<TaskInput> userKafka = MessageBuilder
                .withPayload(taskInput)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();
        kafkaTemplate.send(userKafka);
    }
}