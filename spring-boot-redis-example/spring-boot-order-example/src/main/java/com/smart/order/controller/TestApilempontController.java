package com.smart.order.controller;

import com.smart.order.annotation.Apilempotent;
import com.smart.order.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class TestApilempontController {
    @Resource
    TokenService tokenService;

    @GetMapping("/token")
    public String getToken(){
        return  tokenService.createToken();
    }

    @PostMapping("/test")
    @Apilempotent
    public String  testApi(){
        log.info("testApi=====>>>");
        return "hello";
    }

}
