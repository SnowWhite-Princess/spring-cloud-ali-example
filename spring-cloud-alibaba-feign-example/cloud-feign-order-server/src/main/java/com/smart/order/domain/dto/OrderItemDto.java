package com.smart.order.domain.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderItemDto extends BaseDto {
    //订单号
    private Integer orderId;
    //会员ID
    private Long memberId;
    //商品图片
    private String productPic;
    //商品名称
    private String productName;
    //商品的购买价格
    private Long productPrice;
    //购买的数量
    private Integer productQuantity;

}
