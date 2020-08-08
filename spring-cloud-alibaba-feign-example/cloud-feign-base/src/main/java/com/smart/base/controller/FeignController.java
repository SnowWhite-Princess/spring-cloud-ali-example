package com.smart.base.controller;

import com.smart.base.domain.dto.OrderDto;
import com.smart.base.domain.dto.request.OrderRequestParams;
import com.smart.base.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

//http://127.0.0.1:8889/api/feign/create
@RestController
@RequestMapping("/feign")
@Slf4j
public class FeignController {
    @Resource
    BaseService baseService;

    @PostMapping("/create")
    //接受客户端发送过来的数据
    public String createOrder(@RequestBody OrderRequestParams requestParams){
        log.info(requestParams.toString());
        return baseService.createOrder(requestParams);
    }

    @GetMapping("/list")
    public List<OrderDto> getOrderData(@RequestParam(value = "uid") int uid, @RequestParam("page") int page, @RequestParam("size") int size){
        return baseService.getOrderList(uid,page,size);
    }


}
