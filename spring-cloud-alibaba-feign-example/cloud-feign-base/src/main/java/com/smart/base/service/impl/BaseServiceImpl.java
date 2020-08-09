package com.smart.base.service.impl;

import com.smart.base.domain.dto.OrderDto;
import com.smart.base.domain.dto.PayDto;
import com.smart.base.domain.dto.request.OrderRequestParams;
import com.smart.base.service.BaseService;
import com.smart.base.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 生成订单
 */
@Service
public class BaseServiceImpl implements BaseService {
    @Resource
    OrderService orderService;

    @Override
    public List<OrderDto> getOrderList(int uid, int page, int size){
        return orderService.getOrderData(uid, page, size);

    }

    @Override
    public PayDto createOrder(OrderRequestParams orderRequestParams) {
        return orderService.createOrder(orderRequestParams);
    }
}
