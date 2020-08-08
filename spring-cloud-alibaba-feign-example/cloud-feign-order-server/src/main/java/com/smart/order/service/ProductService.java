package com.smart.order.service;

import com.smart.order.domain.dto.ProductDto;
import com.smart.order.domain.dto.request.OrderRequestParams;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "cloud-feign-order-server-hmy",path = "/api/product")
public interface ProductService {
    @GetMapping("/list")
    public List<ProductDto> list(@RequestParam(value = "ids") List<Integer> ids);

    @PostMapping("/save/")
    public String createOrder(@RequestBody OrderRequestParams requestParams);
}
