package com.smart.nosql.redis.template.utils;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

/*
 *  键
 */
public class RedisUtils {
    @Resource
    RedisTemplate<String, Object> redisTemplate;
    @Resource
    ValueOperations<String, Object> valueOperations;

    public void set(String key,Object object){
        valueOperations.set(key,object);
    }

}
