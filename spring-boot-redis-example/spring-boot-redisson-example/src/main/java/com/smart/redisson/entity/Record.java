package com.smart.redisson.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "record")
public class Record {
    @TableId(value = "record_id", type = IdType.AUTO)
    private Integer recordId;

    @TableField(value = "out_num")
    private Integer outNum;

    @TableField(value = "in_num")
    private Integer inNum;

    @TableField(value = "store_id")
    private Integer storeId;

    public static final String COL_RECORD_ID = "record_id";

    public static final String COL_OUT_NUM = "out_num";

    public static final String COL_IN_NUM = "in_num";

    public static final String COL_STORE_ID = "store_id";
}