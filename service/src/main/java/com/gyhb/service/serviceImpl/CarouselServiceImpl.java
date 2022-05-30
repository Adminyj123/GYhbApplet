package com.gyhb.service.serviceImpl;

import com.gyhb.entity.bo.Carousel;
import com.gyhb.mapper.AppletCarouselMapper;
import com.gyhb.service.CarouselService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CarouselServiceImpl implements CarouselService {

    private final AppletCarouselMapper carouselMapper;

    public CarouselServiceImpl(AppletCarouselMapper carouselMapper) {
        this.carouselMapper = carouselMapper;
    }

    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    @Override
    public List<Carousel> queryAll(Integer isShow) {

        Example example = new Example(Carousel.class);
        example.orderBy("sort").desc();
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isShow", isShow);

        return carouselMapper.selectByExample(example);
    }
}
