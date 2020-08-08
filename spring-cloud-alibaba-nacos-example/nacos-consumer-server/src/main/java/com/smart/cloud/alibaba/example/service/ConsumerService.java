package com.smart.cloud.alibaba.example.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 */
@FeignClient(value = "nacos-provider-server")
public interface ConsumerService {
    @GetMapping("/hello")
    public String hello();
}
