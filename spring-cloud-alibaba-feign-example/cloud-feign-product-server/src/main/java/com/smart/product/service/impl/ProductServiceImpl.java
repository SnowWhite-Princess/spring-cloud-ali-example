package com.smart.product.service.impl;

import com.smart.product.domain.dto.ProductDto;
import com.smart.product.domain.dto.request.OrderRequestParams;
import com.smart.product.domain.entity.Product;
import com.smart.product.mapper.ProductMapper;
import com.smart.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    ProductMapper productMapper;

    @Override
    public ProductDto createProduct(OrderRequestParams orderRequestParams) {
        Product product = new Product();
        ProductDto productDto = new ProductDto();
        productDto.setProductName(orderRequestParams.getProductName());
        productDto.setProductNum(orderRequestParams.getProductNum());
        productDto.setProductPrice(orderRequestParams.getProductPrice());
        BeanUtils.copyProperties(productDto,product);
        productMapper.insert(product);
        return productDto;
    }
}
