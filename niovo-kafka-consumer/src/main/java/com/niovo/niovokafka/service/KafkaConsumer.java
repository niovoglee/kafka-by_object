package com.niovo.niovokafka.service;

import com.niovo.niovokafka.dto.User;
import com.niovo.niovokafka.dto.tesk.TaskInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import static com.niovo.niovokafka.util.AppConstants.GROUP_ID;
import static com.niovo.niovokafka.util.AppConstants.TOPIC_NAME_TASK;
import static com.niovo.niovokafka.util.AppConstants.TOPIC_NAME_USER;

@Service
@Slf4j
public class KafkaConsumer {

//    @KafkaListener(topics = AppConstants.TOPIC_NAME_LOAN, groupId = AppConstants.GROUP_ID)
//    public void consumeLoan(String message) {
//
//        log.info(String.format("Loan Message received -> %s", message));
//    }
//
//    @KafkaListener(topics = AppConstants.TOPIC_NAME_LEAVE, groupId = AppConstants.GROUP_ID)
//    public void consumeLeave(String message) {
//
//        log.info(String.format("Leave Message received -> %s", message));
//    }

    @KafkaListener(topics = TOPIC_NAME_USER, groupId = GROUP_ID)
    public void consumeUser(User user) {

        log.info(String.format("User Message received -> %s", user));
    }

    @KafkaListener(topics = TOPIC_NAME_TASK, groupId = GROUP_ID)
    public void consumeTask(TaskInput taskInput) {

        log.info(String.format("Task Message received -> %s", taskInput));
    }
}