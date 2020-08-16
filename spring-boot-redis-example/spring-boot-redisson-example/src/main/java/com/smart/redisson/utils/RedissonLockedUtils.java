package com.smart.redisson.utils;

import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 获取锁
 * 尝试获取锁
 * 解锁
 */
@Component
public class RedissonLockedUtils {
    @Resource
    RedissonClient redissonClient;



}
