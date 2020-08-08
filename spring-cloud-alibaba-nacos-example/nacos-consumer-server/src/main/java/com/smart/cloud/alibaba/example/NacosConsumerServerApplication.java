package com.smart.cloud.alibaba.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhangwei
 */
@SpringBootApplication
@EnableDiscoveryClient
// 注册所有的 feign
@EnableFeignClients
public class NacosConsumerServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerServerApplication.class, args);
    }
}
