package com.gyhb.service;

import com.gyhb.entity.Appletuser;
import com.gyhb.entity.bo.UserBO;
import com.gyhb.entity.bo.UserVo;

import java.util.List;

public interface AppletUserService  {

    /**
     * 判断微信号是否存在
     */
    public boolean queryWechatIsExist(String WechatNumber);

    /**
     * 注册微信用户
     */
    public Appletuser createUser(UserVo userBO);


    /**
     * 测试用的
     * 查询所有用户
     */
    public List<Appletuser> queryall();

    /**
     * 登录查询用户
     */
    Appletuser queryUserForLogin(String wechatNumber, String md5Str);
}
