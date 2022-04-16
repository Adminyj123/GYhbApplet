package com.gyhb.mapper;

import com.gyhb.entity.Appletcategory;
import com.gyhb.my.mapper.MyMapper;

import java.util.List;

public interface AppletcategoryMapper extends MyMapper<Appletcategory> {

    public List<Appletcategory> findAllByCode(String code);
}