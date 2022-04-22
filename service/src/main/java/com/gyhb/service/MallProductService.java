package com.gyhb.service;

import com.gyhb.entity.Appletmallproduct;
import com.gyhb.utils.utils.IMOOCJSONResult;

import java.util.List;

public interface MallProductService {

    /**
     * 新增商品
     */
    public IMOOCJSONResult addMallProduct(Appletmallproduct appletmallproduct);

   /* *//**
     * 查询商品
     *//*
    public List<Appletmallproduct> queryMallProduct();*/
}
