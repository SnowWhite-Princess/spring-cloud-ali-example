package com.smart.sentinel.example.domian.dto;

import lombok.Data;

import java.util.List;
@Data
public class SentinelDto {
    private String name;
    private List<OrderDto> orderDtoList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<OrderDto> getOrderDtoList() {
        return orderDtoList;
    }

    public void setOrderDtoList(List<OrderDto> orderDtoList) {
        this.orderDtoList = orderDtoList;
    }
}
