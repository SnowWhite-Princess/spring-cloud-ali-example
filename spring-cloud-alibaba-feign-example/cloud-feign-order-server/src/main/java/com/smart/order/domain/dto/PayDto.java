package com.smart.order.domain.dto;

import lombok.Data;

@Data
public class PayDto {
    private String orderNo;
    private String subject;
    private Long total;
    /**
     * 1.微信
     * 2.支付宝
     * 3.银联
     */
    private int payType;
}
