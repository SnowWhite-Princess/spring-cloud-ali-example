package com.smart.cache.example.controller;

import com.smart.cache.example.service.MemberService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MemberController {
    @Resource
    MemberService memberService;
    @PostMapping("/memberLike")
    public String like(@RequestParam String username,@RequestParam int vid) {

        String i = memberService.like(username,vid);
        return i;
    }

    @PostMapping("/memberUnLike")
    public String unlike(@RequestParam String username,@RequestParam int vid) {
        String i = memberService.unlike(username,vid);
        return i;
    }
}
