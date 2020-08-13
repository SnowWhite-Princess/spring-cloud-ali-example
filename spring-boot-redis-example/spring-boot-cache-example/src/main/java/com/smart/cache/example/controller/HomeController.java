package com.smart.cache.example.controller;

import com.smart.cache.example.entity.Member;
import com.smart.cache.example.service.MemberService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 过期时间的设置
 * 缓存雪崩
 */
@RestController
public class HomeController {
    @Resource
    MemberService memberService;

    // 10分钟
    // key 默认使用参数的名称  spEl语法   使用参数作为key 自动以key#root  args

    @Cacheable(value = "members", key = ("#page"))
//    @Cacheable(value = "members", key = ("#root.method" + "." + "root"))
    @GetMapping("/members")
    public List<Member> findAll(int page, int size) {
        return memberService.findAll(page, size);
    }

    // 10天
    @CachePut(value = "members", key = ("targetClass.getName()" + "." + "#method"))
    @PostMapping("/member")
    public int add(@RequestBody Member member) {
        return memberService.save(member);
    }

    @GetMapping("/del")
    @CacheEvict // 清空缓存
    public int clearCache() {
        return 0;
    }

}
