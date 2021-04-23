package com.example.projecttest.service;

import com.example.projecttest.bean.Secure;
import com.example.projecttest.decorator.DataAccess;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;

@Named
public class HelloService {

    @Inject
    DataAccess dataAccess;

    @Secure
    public String save() {
        System.out.println("Hello Service");
        getId(null);
        return "dddd";
    }

}
