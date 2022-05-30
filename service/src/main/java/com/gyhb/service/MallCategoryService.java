package com.gyhb.service;

import com.gyhb.entity.Appletmallcategory;
import com.gyhb.utils.utils.IMOOCJSONResult;

import java.util.List;

/**
 * @author YangJie
 * @date 2022/5/30 11:33
*/
public interface MallCategoryService {

    /**
     * 新增商品列表
     * @param appletmallcategory appletmallcategory
     * @return IMOOCJSONResult
     */
     IMOOCJSONResult addMallCategory(Appletmallcategory appletmallcategory);

    /**
     * 修改商品列表
     * @param appletmallcategory appletmallcategory
     * @return IMOOCJSONResult
     */
    IMOOCJSONResult updateMallCategory(Appletmallcategory appletmallcategory);

    /**
     * 查询商品列表
     * @return List<Appletmallcategory>
     */
     List<Appletmallcategory> queryMallCategory();

    /**
     * 修改商品列表
     * @param lst lst
     * @return IMOOCJSONResult
     */
    IMOOCJSONResult delMallCategory(List<String> lst);
}
