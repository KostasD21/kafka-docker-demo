package com.example.kafkadockerdemo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @KafkaListener(topics = "test-topic", groupId = "foo")
    public void listenGroupFoo(String message) {
        System.out.println("Received Message in group foo: " + message);
    }
}
