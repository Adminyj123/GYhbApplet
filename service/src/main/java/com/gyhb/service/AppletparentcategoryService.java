package com.gyhb.service;

import com.gyhb.entity.Appletparentcategory;
import com.gyhb.entity.bo.CategoryVo;

import java.util.List;

/**
 * @author YangJie
 * @date 2022/5/30 11:22
*/
public interface AppletparentcategoryService {

     /**
      * 查询数据
      * @return List<CategoryVo>
      */
     List<CategoryVo>  queryClassify();

     /**
      * 查询数据
      * @return List<Appletparentcategory>
      */
     List<Appletparentcategory>  queryAllRootLevelCat();

}
