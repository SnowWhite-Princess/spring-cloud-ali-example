package com.smart.product.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import lombok.Data;

/**
    * 产品表
    */
@Data
@TableName(value = "db_product")
public class Product {
    /**
     * 产品ID
     */
    @TableId(value = "product_id", type = IdType.AUTO)
    private Integer productId;

    /**
     * 产品名称
     */
    @TableField(value = "product_name")
    private String productName;

    /**
     * 产品价格
     */
    @TableField(value = "product_price")
    private BigDecimal productPrice;

    /**
     * 产品数量
     */
    @TableField(value = "product_num")
    private Long productNum;

    /**
     * 0:未删除 1：删除
     */
    @TableField(value = "product_status")
    private Integer productStatus;

    public static final String COL_PRODUCT_ID = "product_id";

    public static final String COL_PRODUCT_NAME = "product_name";

    public static final String COL_PRODUCT_PRICE = "product_price";

    public static final String COL_PRODUCT_NUM = "product_num";

    public static final String COL_PRODUCT_STATUS = "product_status";
}