package com.gyhb.service.serviceImpl;

import com.gyhb.entity.AppletUser;
import com.gyhb.mapper.AppletUserMapper;
import com.gyhb.service.AppletUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppletUserServiceImpl implements AppletUserService {

    @Autowired
    protected AppletUserMapper appletUserMapper;

    @Override
    public List<AppletUser> queryall() {
        return appletUserMapper.selectAll();
    }
}
