package com.example.userservice.controller;

import com.example.userservice.domain.entity.User;
import com.example.userservice.domain.req.CalculationRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public class UserController {

    @GetMapping
    public User test() {
        User user = new User();
        user.setUsername("test");
        user.setMessage("Hello World!!!!");
        return user;
    }

    @PostMapping("/calculate")
    public double calculate(@RequestBody CalculationRequest request) {
        switch (request.getOperation().toLowerCase()) {
            case "add":
                return request.getNum1() + request.getNum2();
            case "subtract":
                return request.getNum1() - request.getNum2();
            case "multiply":
                return request.getNum1() * request.getNum2();
            case "divide":
                if (request.getNum2() == 0) {
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
                return request.getNum1() / request.getNum2();
            default:
                throw new IllegalArgumentException("Unsupported operation. Supported operations are: add, subtract, multiply, divide");
        }
    }
} 