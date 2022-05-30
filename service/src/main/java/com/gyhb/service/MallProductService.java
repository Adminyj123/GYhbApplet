package com.gyhb.service;

import com.gyhb.entity.Appletmallproduct;
import com.gyhb.utils.utils.IMOOCJSONResult;
import com.gyhb.utils.utils.PagedGridResult;

import java.util.List;

/**
 * @author YangJie
 * @date 2022/5/26 10:47
*/
public interface MallProductService {

    /**
     * 新增商品
     * @param appletmallproduct appletmallproduct
     * @return IMOOCJSONResult
     */
     IMOOCJSONResult addMallProduct(Appletmallproduct appletmallproduct);

    /**
     * 查询所有商品
     * @return List<Appletmallproduct>
     */
     List<Appletmallproduct> queryMallProduct();

    /**
     * 查询商品详情
     * @param id id
     * @return Appletmallproduct
     */
     Appletmallproduct queryDetails(String id);

    /**
     * 修改商品详情
     * @param appletmallproduct appletmallproduct
     * @return IMOOCJSONResult
     */
     IMOOCJSONResult updateMallProduct(Appletmallproduct appletmallproduct);

    /**
     * 删除商品（批量）
     * @param lst lst
     * @return IMOOCJSONResult
     */
    IMOOCJSONResult deleteMallProduct(List<String> lst);


    /**
     * 查询分页
     * @param ProductName 商品名称
     * @param CategoryId 分类id
     * @param status 状态
     * @param offDateStr 过期时间
     * @param page 分页
     * @param pageSize 每页条数
     * @return PagedGridResult
     */
    PagedGridResult queryPagedMall(String ProductName, String CategoryId, String status,String offDateStr, Integer page, Integer pageSize);

}
