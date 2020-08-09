package com.smart.sentinel.example.service.impl;

import com.smart.sentinel.example.domian.common.RespEntity;
import com.smart.sentinel.example.domian.dto.OrderDto;
import com.smart.sentinel.example.domian.dto.SentinelDto;
import com.smart.sentinel.example.service.OrderService;
import com.smart.sentinel.example.service.SentinelService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

/**
 * 返回的数据有可能需要拼装数据  该怎么处理
 * 返回的数据直接不需要任何拼接  返回给客服
 */
@Service
public class SentinelServiceImpl implements SentinelService {
    @Resource
    OrderService orderService;

    @Override
    public ResponseEntity<String> data() {
        return null;
    }

    @Override
    public ResponseEntity<List<OrderDto>> getOrderList() {
        return null;
    }
}
