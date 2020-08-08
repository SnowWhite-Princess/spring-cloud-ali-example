package com.smart.order.service;

import com.smart.order.domain.dto.OrderDto;
import com.smart.order.domain.dto.PayDto;
import com.smart.order.domain.dto.ProductDto;
import com.smart.order.domain.dto.request.OrderRequestParams;
import com.smart.order.domain.entity.Order;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface OrderService {
    List<ProductDto> list(@RequestParam(value = "ids") List<Integer> ids);
    PayDto createOrder(@RequestBody OrderRequestParams requestParams);
}
