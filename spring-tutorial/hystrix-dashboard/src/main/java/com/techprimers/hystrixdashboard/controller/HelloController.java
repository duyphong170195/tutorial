package com.techprimers.hystrixdashboard.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/say-hello")
    public ResponseEntity<?> sayHello() {
        return ResponseEntity.ok("hello world");
    }
}
