package com.smart.nosql.redis.template;

import com.smart.nosql.redis.template.service.RedisService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class TestRedisService {
    @Resource
    RedisService redisService;
    @Test
    public void testHello(){
        redisService.delete("test:str:nx");
    }


}
