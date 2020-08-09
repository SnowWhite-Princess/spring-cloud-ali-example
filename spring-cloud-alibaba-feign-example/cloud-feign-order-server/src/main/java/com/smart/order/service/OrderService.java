package com.smart.order.service;

import com.smart.order.domain.dto.PayDto;
import com.smart.order.domain.dto.request.OrderRequestParams;
import org.springframework.web.bind.annotation.RequestBody;


public interface OrderService {
    PayDto createOrder(@RequestBody OrderRequestParams requestParams);
}
