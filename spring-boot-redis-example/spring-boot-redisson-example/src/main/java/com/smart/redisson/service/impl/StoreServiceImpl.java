package com.smart.redisson.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.smart.redisson.entity.ProductStore;
import com.smart.redisson.mapper.ProductStoreMapper;
import com.smart.redisson.service.StoreService;
import org.apache.catalina.StoreManager;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 自动释放锁，如何解决误删锁
 * 设置一个唯一的值 删除锁的时候判断值是否一致
 */
@Service
public class StoreServiceImpl implements StoreService {
    @Resource
    RedissonClient redissonClient;
    @Resource
    RedisTemplate<String,String> redisTemplate;
    @Resource
    ProductStoreMapper storeMapper;

    @Override
    public boolean decre(int productId, int count) {
        boolean isSuccess = false;
        /**
         * ProductStore
         * 判断库存是否足够
         * 1.从数据库查询
         * 2.如果库存够
         */
        QueryWrapper<ProductStore> qw = new QueryWrapper<>();
        qw.eq(ProductStore.COL_PRODUCT_ID,productId);
//        redisTemplate.opsForValue().decrement("store:productstore:productId:1",count)
        ProductStore store = storeMapper.selectOne(qw);
        Integer num = store.getNum();
        if (num > 0 && num >= count){
            store.setNum(num - count);
            storeMapper.updateById(store);
            isSuccess = true;
        }else {
            new Exception("库存不足");
        }
        return isSuccess;
    }
}
