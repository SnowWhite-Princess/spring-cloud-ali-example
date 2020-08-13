package com.smart.nosql.redis.template;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

import javax.annotation.Resource;

@SpringBootTest
public class TestRedisOption {
    @Resource
    RedisTemplate<String,Object> redisTemplate;

    @Resource
    ValueOperations<String,Object> valueOperations;

    @Resource
    SetOperations<String,Object> setOperations;

    @Test
    public void testValueForString(){
        //操作String的数据
//        ValueOperations<String,Object> operations = redisTemplate.opsForValue();
//        operations.set("username","admin");
        valueOperations.set("password","root");
    }


    @Test
    public void testSetForString(){
        ListOperations<String,Object> operations = redisTemplate.opsForList();
        operations.leftPushAll("shops","华为","小米","op");

    }

    @Test
    public void testHash(){
        HashOperations<String,String,Object> operations = redisTemplate.opsForHash();
        operations.put("user","username","admin");
        operations.put("user","age","18");

    }
    @Test
    public void testSet(){
    setOperations.add("user:test","mins");
    }

}
