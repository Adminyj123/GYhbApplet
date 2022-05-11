package com.gyhb.service;

import com.gyhb.entity.Appletmallcategory;
import com.gyhb.utils.utils.IMOOCJSONResult;

import java.util.List;

public interface MallCategoryService {

    /**
     * 新增商品列表
     */
     IMOOCJSONResult addMallCategory(Appletmallcategory appletmallcategory);

    /**
     * 修改商品列表
     */
    IMOOCJSONResult updateMallCategory(Appletmallcategory appletmallcategory);

    /**
     * 查询商品列表
     */
     List<Appletmallcategory> queryMallCategory();

    /**
     * 修改商品列表
     */
    IMOOCJSONResult delMallCategory(List<String> lst);
}
