package com.smart.order.domain.dto;

import lombok.Data;

@Data
public class OrderAddressDto extends BaseDto {
    private Integer id;
    //收货地址
    private String address;
    //收货手机号
    private String phone;
    //订单号
    private Integer orderId;
}
