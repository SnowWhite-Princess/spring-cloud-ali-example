package com.smart.cache.example.controller;

import com.smart.cache.example.service.VideoService;
import com.smart.cache.example.vo.VideoVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class VideoController {
    @Resource
    VideoService videoService;

    /**
     * video:vid:1 set  显示名称
     * 关键这个key生成
     */
    @PostMapping("/like")
    public Long like(@RequestParam int vid) {
        Long i = videoService.like(vid);
        return i;
    }

    @PostMapping("/detail")
    public VideoVo detail(@RequestParam int vid) {
        VideoVo videoVo = videoService.findById(vid);
        return videoVo;
    }
}
