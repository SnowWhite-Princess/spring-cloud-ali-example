package com.smart.cache.example.service;

import com.smart.cache.example.vo.VideoVo;

public interface VideoService {
    Long like(int vid);

    VideoVo findById(int vid);

}
