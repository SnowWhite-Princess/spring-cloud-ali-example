package com.smart.dubbo.service.impl;

import com.smart.dubbo.api.dto.UserDto;
import com.smart.dubbo.api.service.HelloDubboService;
import org.apache.dubbo.config.annotation.Service;

@Service
public class HelloDubboServiceImpl  implements HelloDubboService {

    @Override
    public UserDto user(int uid) {
        UserDto userDto = new UserDto();
        userDto.setUsername("憨憨");
        userDto.setPassword("admin");
        return userDto;
    }
}
