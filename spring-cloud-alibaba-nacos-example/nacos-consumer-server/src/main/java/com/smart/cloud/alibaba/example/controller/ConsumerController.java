package com.smart.cloud.alibaba.example.controller;

import com.smart.cloud.alibaba.example.service.ConsumerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 */
@RestController
public class ConsumerController {
    @Resource
    ConsumerService service;

    @GetMapping("/hello")
    public String hello() {
        //从消费者返回的数据
        String hello = service.hello();
        return hello;
    }
}
