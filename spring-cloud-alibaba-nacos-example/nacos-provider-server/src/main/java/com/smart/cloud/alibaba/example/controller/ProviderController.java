package com.smart.cloud.alibaba.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProviderController {

    @GetMapping("/hello")
    public String hello() {
        return "hello  nacos  provider";
    }

    @GetMapping("/list")
    public String list(int page, int size) {
        return "hello  nacos  provider list";
    }

}
