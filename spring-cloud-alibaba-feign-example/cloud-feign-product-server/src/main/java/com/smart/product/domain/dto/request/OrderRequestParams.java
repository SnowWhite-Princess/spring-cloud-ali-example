package com.smart.product.domain.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderRequestParams extends BaseRequestParams {
    /**
     * 产品名称
     */
    private String productName;

    /**
     * 产品价格
     */
    private BigDecimal productPrice;

    /**
     * 产品数量
     */
    private Long productNum;

}
