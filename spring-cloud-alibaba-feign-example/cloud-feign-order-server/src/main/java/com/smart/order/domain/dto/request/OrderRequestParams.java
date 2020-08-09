package com.smart.order.domain.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderRequestParams extends BaseRequestParams {
    //订单号
    private String orderNo;
    //总价
    private Long total;
    //会员ID
    private Long memberId;
    //订单详情ID
    private Integer ids;
    //订单详情订单号
    private Integer orderId;
    //商品的图片
    private String productPic;
    //商品名称
    private String productName;
    //商品购买数量
    private Integer productQuantity;
    //收货地址
    private String address;
    //收货手机号
    private String phone;
    /**
     * 1   表示顺丰
     * 2   表示圆通
     * 3   表示申通
     */
    private int expressType;
    //产品价格
    private BigDecimal productPrice;
    //产品数量
    private Long productNum;

}
