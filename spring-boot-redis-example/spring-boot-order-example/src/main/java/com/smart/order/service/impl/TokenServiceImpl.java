package com.smart.order.service.impl;

import com.smart.order.service.RedisService;
import com.smart.order.service.TokenService;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class TokenServiceImpl implements TokenService {
    @Resource
    RedisService redisService;
    /**
     * 1> 生成token
     * 2> 保存到redis中
     * @return
     */
    @Override
    public String createToken() {
        String token = UUID.randomUUID().toString().replace("-", "");
        redisService.setEx(token,token,2, TimeUnit.HOURS);
        return token;
    }

    @Override
    public boolean checkToken(HttpServletRequest request) {
        return false;
    }
}
