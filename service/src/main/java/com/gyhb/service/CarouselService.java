package com.gyhb.service;

import com.gyhb.entity.bo.Carousel;

import java.util.List;

public interface CarouselService {

    /**
     * 查询所有轮播图列表
     */
     List<Carousel> queryAll(Integer isShow);

}
