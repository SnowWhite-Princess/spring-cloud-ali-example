package com.smart.nosql.redis.template;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import java.time.Duration;

@SpringBootTest
@Slf4j
public class TestValueOptions {
    @Resource
    ValueOperations<String, Object> valueOperations;

    /**
     * 设置过期时间
     */
    @Test
    public void testSetEx() {
        try {
            valueOperations.set("test:string:timeout", "hello", Duration.ofMillis(1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void testSetNx() {
        try {
            // 如果键不存在则设置,否则不设置值
            valueOperations.setIfAbsent("test:str:nx", "12345");
            //如果键存在则设置值  否则不设置
            valueOperations.setIfPresent("test:str:nx1", "存在才设置值");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 设置过期时间
     */
    @Test
    public void testIncr() {
        try {
            Long uid = valueOperations.increment("test:str:uid");
            log.info("自增{}", uid);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    public void testGetAndSet() {
        //设置新值 返回旧值
        // 0
        Object object = valueOperations.getAndSet("test:str:get", "1234");
        Integer value1 = (Integer) valueOperations.get("test:str:uid");
        log.info(object.toString());
        log.info(value1 + "");
    }


}
