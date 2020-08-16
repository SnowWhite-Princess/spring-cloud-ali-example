package com.smart.redisson.controller;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class LockedController {
    @Resource
    RedissonClient redissonClient;
    int count = 100;

    @GetMapping("/lock1")
    public String decre1(){
        if (count >= 1){
            count--;
            log.info("无锁版----》》》",count);
        }
        return "success";
    }


//生成订单，减少库存
    /**
     * 库存服务
     * 库存主表 id  product_id  num
     * 库存记录表    入库数量    出库的数量
     * @return
     * @throws Exception
     */
    @GetMapping("/lock")
    public String deincr() throws Exception {
        //设置key,Redis里面的key,获取里面的锁
        RLock lock = redissonClient.getLock("lock");
        try {
            //尝试获取锁，最多等待十秒，上锁以后3秒自动解锁
            boolean res = lock.tryLock(10, 3, TimeUnit.SECONDS);
            if (res) {
                //执行核心代码
                if (count >= 1){
                    count--;
                    log.info(count + "");

                }
            }
        } catch (Exception e) {
            throw new Exception("服务器繁忙，请稍后再试!!");
        } finally {
            //释放锁
//            lock.unlock();
            lock.forceUnlock();
        }
        return "success";
    }
}
