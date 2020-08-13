package com.smart.cache.example.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class VideoVo {
    private Integer vid;
    private String url;
    private Integer status;
    private String title;
    private int like;

}
