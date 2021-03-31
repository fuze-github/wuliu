package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.Impl.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping("/test")
    public User test(Integer id){

        return testService.test(id);
    }
}
