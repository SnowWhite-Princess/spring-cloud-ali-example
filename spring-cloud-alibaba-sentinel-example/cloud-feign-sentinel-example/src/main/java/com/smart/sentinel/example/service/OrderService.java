package com.smart.sentinel.example.service;


import com.smart.sentinel.example.domian.common.RespEntity;
import com.smart.sentinel.example.domian.dto.OrderDto;
import com.smart.sentinel.example.domian.dto.request.OrderRequestParams;
import com.smart.sentinel.example.fallback.OrderFallBackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 网关
 */
@FeignClient(value = "cloud-feign-order-server-hmy", path = "/api/order", fallback = OrderFallBackService.class)
public interface OrderService {
    @GetMapping("/")
    RespEntity<List<OrderDto>> getOrderData(@RequestParam(value = "uid") int uid, @RequestParam("page") int page, @RequestParam("size") int size);

    @PostMapping("/save/")
    String createOrder(@RequestBody OrderRequestParams requestParams);

}
