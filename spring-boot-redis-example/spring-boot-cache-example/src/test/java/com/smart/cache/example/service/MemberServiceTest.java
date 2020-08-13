package com.smart.cache.example.service;

import com.smart.cache.example.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class MemberServiceTest {
    @Resource
    MemberService memberService;

    @Test
    void findAll() {
//        List<Member> all = memberService.findAll(1, 10);
        List<Member> all = memberService.findAll();
        log.info(all.toString());
    }
}