package com.smart.cache.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "tb_video")
public class Video implements Serializable {
    @TableId(value = "vid", type = IdType.AUTO)
    private Integer vid;

    @TableField(value = "url")
    private String url;

    @TableField(value = "status")
    private Integer status;

    @TableField(value = "title")
    private String title;

    public static final String COL_VID = "vid";

    public static final String COL_URL = "url";

    public static final String COL_STATUS = "status";

    public static final String COL_TITLE = "title";
}