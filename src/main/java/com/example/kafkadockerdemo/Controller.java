package com.example.kafkadockerdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class Controller {

    @Autowired
    private UserService userService;

    @GetMapping(path = "user")
    public ResponseEntity findAllUsers() {
        User user = new User("KostasD21","xxx");
        user.setId(1L);
        userService.createUser(user);
        return ResponseEntity.ok().build();
    }
}
