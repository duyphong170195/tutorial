package com.example.projecttest.controller;

import com.example.projecttest.model.Login;
import com.example.projecttest.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;

@RestController
public class HelloController {

    @Inject
    Login login;

//    @Inject
//    String currentUser;

    @Inject
    HelloService helloService;

    @GetMapping("/hello")
    public String sayHello() {
        return helloService.save();
    }
}
