package com.smart.product.service;

import com.smart.product.domain.dto.ProductDto;
import com.smart.product.domain.dto.request.OrderRequestParams;
import org.springframework.web.bind.annotation.RequestBody;

public interface ProductService {
    ProductDto createProduct(@RequestBody OrderRequestParams orderRequestParams);
}
