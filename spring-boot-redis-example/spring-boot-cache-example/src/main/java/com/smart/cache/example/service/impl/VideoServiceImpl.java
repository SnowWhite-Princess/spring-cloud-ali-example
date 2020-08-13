package com.smart.cache.example.service.impl;

import com.smart.cache.example.entity.Video;
import com.smart.cache.example.mapper.VideoMapper;
import com.smart.cache.example.service.RedisService;
import com.smart.cache.example.service.VideoService;
import com.smart.cache.example.utils.RedisKeyUtils;
import com.smart.cache.example.vo.VideoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class VideoServiceImpl implements VideoService {
    @Resource
    RedisService redisService;
    @Resource
    VideoMapper mapper;

    @Override
    public Long like(int vid) {
        Long i = redisService.incrBy(RedisKeyUtils.getKeyWithColumn("video", "vid", vid + ""), 1);
        return i;
    }

    @Override
    public VideoVo findById(int vid) {
        VideoVo videoVo = new VideoVo();
        Video video = mapper.selectById(vid);
        BeanUtils.copyProperties(video, videoVo);
        // 查询点赞数
        int like = (int) redisService.get(RedisKeyUtils.getKeyWithColumn("video", "vid", vid + ""));
        videoVo.setLike(like);
        return videoVo;
    }
}
