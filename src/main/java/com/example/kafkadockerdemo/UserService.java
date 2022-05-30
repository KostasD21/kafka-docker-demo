package com.example.kafkadockerdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Transactional(propagation = Propagation.REQUIRED)
    public User createUser(User user) {
        sendMessage(String.format("com.example.kafkadockerdemo.User with id %s was created!", user.getId()));
        return user;
    }

    private void sendMessage(String msg) {
        kafkaTemplate.send("test-topic", msg);
    }
}
