package com.smart.cache.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smart.cache.example.entity.Member;
import com.smart.cache.example.mapper.MemberMapper;
import com.smart.cache.example.service.MemberService;
import com.smart.cache.example.service.RedisService;
import com.smart.cache.example.utils.RedisKeyUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class MemberServiceImpl implements MemberService {
    @Resource
    MemberMapper memberMapper;
    @Resource
    RedisService redisService;
    @Resource
    RedisTemplate<String,Object> redisTemplate;
    public static final String CACHE_MEMBER_FIND_ALL = "cache:member:findall";

    @Override
    public List<Member> findAll(int page, int size) {
        Page<Member> memberPage = memberMapper.selectPage(new Page<Member>(page, size), null);
        return memberPage.getRecords();
    }

    @Override
    public int save(Member member) {
        memberMapper.insert(member);
        return 0;
    }

    @Override
    public List<Member> findAll() {
        //1 先从缓存查找
        String str = (String) redisService.get(CACHE_MEMBER_FIND_ALL);
        if (str != null) {
            List<Member> members = JSONObject.parseArray(str, Member.class);
            log.info("缓存--------滴滴");
            return members;
        } else {
            Page<Member> memberPage = memberMapper.selectPage(new Page<Member>(1, 10), null);
            redisService.setEx(CACHE_MEMBER_FIND_ALL, JSONObject.toJSONString(memberPage.getRecords()), 1, TimeUnit.MINUTES);
            log.info("数据库--------滴滴");
            return memberPage.getRecords();
        }
    }

    @Override
    public String like(String username,int vid) {
        HashOperations<String,String,Object> operations = redisTemplate.opsForHash();
        Boolean key = operations.hasKey("member", "like");
        operations.put("member","username",username);
        if (key == true){
            return "你已经点过赞啦！";
        }else {
            Long i = redisService.incrBy(RedisKeyUtils.getKeyWithColumn("member", "vid", vid + ""), 1);
            operations.put("member","like",i);
            return username+"点赞了"+vid+",一共有"+i+"个Like";
        }
    }

    @Override
    public String unlike(String username,int vid) {
        HashOperations<String,String,Object> operations = redisTemplate.opsForHash();
        Boolean key = operations.hasKey("member", "like");
        if (key == true){
            Long i = redisService.incrBy(RedisKeyUtils.getKeyWithColumn("member", "vid", vid + ""), -1);
            operations.delete("member","like");
            return "取消点赞成功";
        }else {
            return "你还没点赞呢";
        }
    }
}
