package com.smart.cache.example.cache;

import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;

/**
 *  应用程序的性能
 *  写业务
 * token
 * redis
 *
 */
public class MyBatisCache implements Cache {
    private String id;
    private RedisTemplate<String,Object> redisTemplate;

    public MyBatisCache(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    /**
     * 查询完成之后封装对象
     * if (cache!=null){
     *     cache.putObject(key,value)
     * }
     *返回数据
     *
     * @param key
     * @param value
     */
    @Override
    public void putObject(Object key, Object value) {
        getRedisTemplate().opsForValue().set((String)key,value, Duration.ofMinutes(30));
    }

    @Override
    public Object getObject(Object key) {
        return getRedisTemplate().opsForValue().get(key);
    }

    @Override
    public Object removeObject(Object key) {
        Boolean delete = getRedisTemplate().delete(key.toString());
        return delete;
    }

    @Override
    public void clear() {
             getRedisTemplate().execute((RedisCallback<Object>) connection -> {
                 connection.flushDb();
                 return null;
             });
    }

    @Override
    public int getSize() {
        return 0;
    }

    public  RedisTemplate<String,Object> getRedisTemplate(){
        if (redisTemplate!= null){
            redisTemplate =  ApplicationContextHolder.getBean("redisTemplate");
        }
        return  redisTemplate;
    }



}
