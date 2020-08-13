package com.smart.dubbo.consumer.controller;

import com.smart.dubbo.api.dto.UserDto;
import com.smart.dubbo.consumer.service.HomeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HomeController {
    @Resource
    HomeService homeService;
    @GetMapping("/index")
    public UserDto index(){
        UserDto hotData = homeService.getHotData();
        return hotData;
    }
}
