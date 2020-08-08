package com.smart.cloud.alibaba.example.service;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl  implements UserService{
    @Resource
    ConsumerService  consumerService;

    @Override
    public String list() {
        String hello = consumerService.hello();
        return null;
    }
}
