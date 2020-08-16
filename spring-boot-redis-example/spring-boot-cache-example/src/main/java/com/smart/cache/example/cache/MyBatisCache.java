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

    //mybatis缓存操作对象的标识符。一个mapper对应一个mybatis的缓存操作对象。
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
    //查询结果塞入缓存
    @Override
    public void putObject(Object key, Object value) {
        getRedisTemplate().opsForValue().set((String)key,value, Duration.ofMinutes(30));
    }

    //从缓存中获取被缓存的查询结果。
    @Override
    public Object getObject(Object key) {
        return getRedisTemplate().opsForValue().get(key);
    }

    //从缓存中删除对应的key、value。只有在回滚时触发。一般我们也可以不用实现
    @Override
    public Object removeObject(Object key) {
        Boolean delete = getRedisTemplate().delete(key.toString());
        return delete;
    }

    //发生更新时，清除缓存
    @Override
    public void clear() {
             getRedisTemplate().execute((RedisCallback<Object>) connection -> {
                 connection.flushDb();
                 return null;
             });
    }

    //可选实现。返回缓存的数量。
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
