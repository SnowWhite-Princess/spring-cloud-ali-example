package com.smart.base.service;

import com.smart.base.domain.dto.OrderDto;
import com.smart.base.domain.dto.request.OrderRequestParams;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 控制层
 * 接受请求
 * 响应数据
 * http://ip:端口/api/order baseUrl
 */
//value:调用的服务的名称   path: 指控制层根路径
@FeignClient(value = "cloud-feign-order-server-hmy",path = "/api/order")
public interface OrderService {
    @GetMapping("/list/")
    public List<OrderDto> getOrderData(@RequestParam(value = "uid") int uid, @RequestParam("page") int page, @RequestParam("size") int size);

    @PostMapping("/save/")
//    @PostMapping("/order/save/")  拿order-server controller 的接口
    public String createOrder(@RequestBody OrderRequestParams requestParams);
}
