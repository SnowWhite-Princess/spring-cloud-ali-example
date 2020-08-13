package com.smart.nosql.redis.template.db.impl;

import com.smart.nosql.redis.template.db.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RedisServiceImpl implements RedisService {
    @Resource
    RedisTemplate<String,Object> redisTemplate;
    @Resource
    ValueOperations<String,Object> valueOperations;

    @Override
    public void set(String key, Object object) {

    }
}
