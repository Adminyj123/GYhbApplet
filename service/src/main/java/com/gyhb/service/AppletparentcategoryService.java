package com.gyhb.service;

import com.gyhb.entity.Appletparentcategory;
import com.gyhb.entity.bo.CategoryVo;

import java.util.List;

public interface AppletparentcategoryService {

     List<CategoryVo>  queryClassify();

     List<Appletparentcategory>  queryAllRootLevelCat();

}
