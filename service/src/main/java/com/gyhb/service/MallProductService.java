package com.gyhb.service;

import com.gyhb.entity.Appletmallproduct;
import com.gyhb.utils.utils.IMOOCJSONResult;

import java.util.List;

public interface MallProductService {

    /**
     * 新增商品
     */
    public IMOOCJSONResult addMallProduct(Appletmallproduct appletmallproduct);


    /**
     * 查询所有商品
     */
    public List<Appletmallproduct> queryMallProduct();

    /**
     * 查询商品详情
     */
    public Appletmallproduct queryDetails(String id);

    /**
     * 修改商品详情
     */
    public IMOOCJSONResult updateMallProduct(Appletmallproduct appletmallproduct);

    /**
     * 删除商品详情
     */
    public int deleteMallProduct(String id);

}
