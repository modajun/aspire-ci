package com.example.userservice.controller;

import com.example.userservice.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class UserController {

    @GetMapping
    public User test() {
        User user = new User();
        user.setUsername("test");
        user.setMessage("Hello World!");
        return user;
    }
} 