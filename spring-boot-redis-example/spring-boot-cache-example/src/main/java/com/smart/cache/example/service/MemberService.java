package com.smart.cache.example.service;

import com.smart.cache.example.entity.Member;

import java.util.List;

public interface MemberService {
    List<Member> findAll(int page, int size);
    List<Member> findAll();
    String like(String username,int vid);
    String unlike(String username,int vid);
    int save(Member member);
}
