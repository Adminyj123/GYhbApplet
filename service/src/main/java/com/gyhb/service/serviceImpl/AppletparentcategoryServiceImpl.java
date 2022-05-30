package com.gyhb.service.serviceImpl;

import com.gyhb.entity.Appletparentcategory;
import com.gyhb.entity.bo.CategoryVo;
import com.gyhb.mapper.AppletparentcategoryMapper;
import com.gyhb.service.AppletparentcategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author Admin-Yj
 */
@Service
public class AppletparentcategoryServiceImpl implements AppletparentcategoryService {

    private final AppletparentcategoryMapper parentCategoryMapper;

    public AppletparentcategoryServiceImpl(AppletparentcategoryMapper parentCategoryMapper) {
        this.parentCategoryMapper = parentCategoryMapper;
    }

    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    @Override
    public List<CategoryVo> queryClassify() {
        return parentCategoryMapper.queryClassify();
    }

    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    @Override
    public List<Appletparentcategory> queryAllRootLevelCat() {
        Example example = new Example(Appletparentcategory.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("validflag", 0);

        return parentCategoryMapper.selectByExample(example);
    }

}
