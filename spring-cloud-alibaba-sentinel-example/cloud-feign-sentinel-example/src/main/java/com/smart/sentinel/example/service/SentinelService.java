package com.smart.sentinel.example.service;

import com.smart.sentinel.example.domian.dto.OrderDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SentinelService {
    ResponseEntity<String> data();
    ResponseEntity<List<OrderDto>> getOrderList();
}
