package com.gyhb.mapper;

import com.gyhb.entity.Appletmallproduct;
import com.gyhb.my.mapper.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AppletmallproductMapper extends MyMapper<Appletmallproduct> {

    List<Appletmallproduct> queryMallPage(@Param("paramsMap") Map<String, Object> map);
}