package com.gyhb.service;

import com.gyhb.entity.Appletmallcategory;
import com.gyhb.utils.utils.IMOOCJSONResult;

import java.util.List;

public interface MallCategoryService {

    /**
     * 新增商品列表
     */
    public IMOOCJSONResult addMallCategory(Appletmallcategory appletmallcategory);
}
