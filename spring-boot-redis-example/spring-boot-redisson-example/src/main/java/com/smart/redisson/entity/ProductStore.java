package com.smart.redisson.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "product_store")
public class ProductStore {
    /**
     * 库存住建

     */
    @TableId(value = "store_id", type = IdType.AUTO)
    private Integer storeId;

    @TableField(value = "num")
    private Integer num;

    @TableField(value = "product_id")
    private Integer productId;

    public static final String COL_STORE_ID = "store_id";

    public static final String COL_NUM = "num";

    public static final String COL_PRODUCT_ID = "product_id";
}