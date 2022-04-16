package com.gyhb.mapper;

import com.gyhb.entity.Appletparentcategory;
import com.gyhb.entity.bo.CategoryVo;
import com.gyhb.my.mapper.MyMapper;

import java.util.List;

public interface AppletparentcategoryMapper extends MyMapper<Appletparentcategory> {

    public List<CategoryVo> queryClassify();
}