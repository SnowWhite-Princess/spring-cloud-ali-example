package com.smart.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1> 判断是否重复提交
 * 2> 怎么判断
 * 3> 那些是需要判断
 * 4> 如何实现
 * 4.1 > 请求创建标识(token)
 *将token保存redis中
 * 1 如果token存在 正常处理业务逻辑 删除token
 * 2 如果不存在表示已经提交
 *
 * redis
 * 拦截器
 *
 *
 * 用户信息需要求  密码
 * update 通过用户id + 密码
 * 减少库存  -1
 *
 * jwt  uid   过期时间 token
 * 防重复提交  redis +  拦截器 + token  字符串
 */

//GET:http://127.0.0.1:8080/token

@SpringBootApplication
@MapperScan("com.smart.order.mapper")
public class OrderApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class,args);
    }
}
