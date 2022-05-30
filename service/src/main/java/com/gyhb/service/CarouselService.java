package com.gyhb.service;

import com.gyhb.entity.bo.Carousel;

import java.util.List;

/**
 * @author YangJie
 * @date 2022/5/30 11:33
*/
public interface CarouselService {

    /**
     * 查询所有轮播图列表
     * @param isShow isShow
     * @return List<Carousel>
     */
     List<Carousel> queryAll(Integer isShow);

}
