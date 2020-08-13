package com.smart.dubbo.consumer.service.impl;

import com.smart.dubbo.api.dto.UserDto;
import com.smart.dubbo.api.service.HelloDubboService;
import com.smart.dubbo.consumer.service.HomeService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
//在提供者 使用 Service 注册
//在消费者 使用 Reference 注册
//rest 消费者是调用提供者的控制层
//rpc  消费者是调用提供者的service层

@Service
public class HomeServiceImpl implements HomeService {
    @Reference
    HelloDubboService helloDubboService;
    @Override
    public UserDto getHotData() {
        UserDto user = helloDubboService.user(1);
        return user;
    }
}
