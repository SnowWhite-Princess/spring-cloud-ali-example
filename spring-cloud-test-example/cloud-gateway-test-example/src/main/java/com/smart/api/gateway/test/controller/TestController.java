package com.smart.api.gateway.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/hello")
    public String hello(){
        return "hello gateway";
    }

    @PostMapping("/post")
    public String testPost(){
        return "hello Post";
    }

    @GetMapping("/query")
    public String testQuery(String username,String password){
        return "hello query";
    }
}
