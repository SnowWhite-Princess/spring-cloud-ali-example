package com.smart.product.controller;

import com.smart.product.domain.dto.ProductDto;
import com.smart.product.domain.dto.request.OrderRequestParams;
import com.smart.product.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Resource
    ProductService productService;
    //select * from product where pid in (1,2,3,4,5)
    @GetMapping("/list")
    public List<ProductDto> list(@RequestParam List<Integer> ids) {
        return new ArrayList<>();
    }

    @PostMapping("/save")
    public ProductDto createProduct(@RequestBody OrderRequestParams orderRequestParams){
        return productService.createProduct(orderRequestParams);
    }
}
