package com.smart.order.controller;

import com.smart.order.domain.dto.OrderDto;
import com.smart.order.domain.dto.PayDto;
import com.smart.order.domain.dto.request.OrderRequestParams;
import com.smart.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Resource
    OrderService orderService;

    /**
     * 创建订单
     */
    @PostMapping("/save/")
    public PayDto createOrder(@RequestBody OrderRequestParams requestParams) {
        log.info(requestParams.toString());
        PayDto order = orderService.createOrder(requestParams);
        return order;
    }

    @GetMapping("/list/")
    public List<OrderDto> getOrderData(@RequestParam int uid, @RequestParam int page, @RequestParam int size) {
        return null;
    }

    /**
     * 确认订单
     * 发起支付
     *      订单号
     *      订单的标题
     *      支付的金额
     *      点击支付
     */


}
