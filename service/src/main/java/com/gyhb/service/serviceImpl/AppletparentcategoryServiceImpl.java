package com.gyhb.service.serviceImpl;

import com.gyhb.entity.Appletparentcategory;
import com.gyhb.entity.bo.CategoryVo;
import com.gyhb.mapper.AppletparentcategoryMapper;
import com.gyhb.service.AppletparentcategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class AppletparentcategoryServiceImpl implements AppletparentcategoryService {

    @Autowired
    private AppletparentcategoryMapper parentcategoryMapper;

    @Override
    public List<CategoryVo> queryClassify() {
        List<CategoryVo> result =  parentcategoryMapper.queryClassify();
        return result;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Appletparentcategory> queryAllRootLevelCat() {
        Example example = new Example(Appletparentcategory.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("validflag", 0);

        List<Appletparentcategory> result =  parentcategoryMapper.selectByExample(example);

        return result;
    }

}
