package com.gyhb.service;

import com.gyhb.entity.Appletmallproduct;
import com.gyhb.utils.utils.IMOOCJSONResult;
import com.gyhb.utils.utils.PagedGridResult;

import java.util.List;

public interface MallProductService {

    /**
     * 新增商品
     */
     IMOOCJSONResult addMallProduct(Appletmallproduct appletmallproduct);


    /**
     * 查询所有商品
     */
     List<Appletmallproduct> queryMallProduct();

    /**
     * 查询商品详情
     */
     Appletmallproduct queryDetails(String id);

    /**
     * 修改商品详情
     */
     IMOOCJSONResult updateMallProduct(Appletmallproduct appletmallproduct);

    /**
     * 删除商品详情
     */
    IMOOCJSONResult deleteMallProduct(List<String> lst);

     /*
     * 查询商品分页
     * */
    PagedGridResult queryPagedMall(String ProductName, String CategoryId, String status,String offDateStr, Integer page, Integer pageSize);

}
