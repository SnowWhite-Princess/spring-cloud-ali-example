package com.smart.sentinel.example.controller;

import com.smart.sentinel.example.domian.common.RespEntity;
import com.smart.sentinel.example.domian.dto.OrderDto;
import com.smart.sentinel.example.domian.dto.request.OrderRequestParams;
import com.smart.sentinel.example.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class SentinelController {
    @Resource
    OrderService orderService;

    @GetMapping("/list")
    public RespEntity<List<OrderDto>> list() {
        return orderService.getOrderData(1, 1, 10);
    }

    @PostMapping("/add")
    public RespEntity<String> createOrder(@RequestBody OrderRequestParams orderRequestParams) {
        String order = orderService.createOrder(orderRequestParams);
        return RespEntity.success(order);
    }

}
