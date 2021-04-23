package com.example.projecttest.model;

import lombok.extern.java.Log;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
@Named
@Stateful
public class Login implements Serializable {

    @Produces
    String getCurrentUser() {
        return "hello Phong";
    }
}