package com.smart.product.controller;

import com.smart.product.domain.dto.ProductDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    //select * from product where pid in (1,2,3,4,5)
    @GetMapping("/list")
    public List<ProductDto> list(@RequestParam List<Integer> ids) {
        return new ArrayList<>();
    }
}
