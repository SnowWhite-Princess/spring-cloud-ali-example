package com.smart.order.domain.dto;

import lombok.Data;

import java.util.Date;

/**
 * 创建订单：
 *      收货地址，商品的信息，物流的方式
 */
@Data
public class OrderDto extends BaseDto {
    private String orderNo;
    private Long total;
    private Long memberId;

}
