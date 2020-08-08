package com.smart.base.service;

import com.smart.base.domain.dto.OrderDto;
import com.smart.base.domain.dto.request.OrderRequestParams;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface BaseService {
    List<OrderDto> getOrderList(int uid, int page, int size);

    String createOrder(@RequestBody OrderRequestParams orderRequestParams);
}
