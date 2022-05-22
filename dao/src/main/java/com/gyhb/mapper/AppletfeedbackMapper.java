package com.gyhb.mapper;

import com.gyhb.entity.Appletfeedback;
import com.gyhb.entity.Appletmallproduct;
import com.gyhb.my.mapper.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AppletfeedbackMapper extends MyMapper<Appletfeedback> {

    /**
     * @param map
     * @return List<Appletfeedback>
     */
    List<Appletfeedback> queryPage(@Param("paramsMap") Map<String, Object> map);
}