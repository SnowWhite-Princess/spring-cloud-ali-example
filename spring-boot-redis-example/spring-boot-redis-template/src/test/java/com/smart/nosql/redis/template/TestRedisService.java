package com.smart.nosql.redis.template;

import com.smart.nosql.redis.template.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
@Slf4j
public class TestRedisService {
    @Resource
    RedisService redisService;
    @Test
    public void testHello(){
//        redisService.delete("test:str:nx");
        String str = (String)redisService.lIndex("shops", 1);
        log.info(str);
    }


}
