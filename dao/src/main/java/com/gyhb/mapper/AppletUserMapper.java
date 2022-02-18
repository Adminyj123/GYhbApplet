package com.gyhb.mapper;



import com.gyhb.entity.AppletUser;
import com.gyhb.my.mapper.MyMapper;

import java.util.List;


public interface AppletUserMapper extends MyMapper<AppletUser> {

    public List<AppletUser> querytest();

}