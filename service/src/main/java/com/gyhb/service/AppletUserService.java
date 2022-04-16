package com.gyhb.service;

import com.gyhb.entity.Appletuser;
import com.gyhb.entity.bo.UserVo;

public interface AppletUserService {

    /**
     * 判断微信号是否存在
     */
    public boolean queryWechatIsExist(String WechatNumber);

    /**
     * 注册微信用户
     */
    public Appletuser createUser(UserVo userBO);


    /**
     * 查询微信用户信息
     */
    public Appletuser queryByWx(String wechatNumber);

    /**
     * 登录查询用户
     */
    Appletuser queryUserForLogin(String wechatNumber, String md5Str);

    /**
     * 登录查询用户
     */
    public  Appletuser addUser(String res);

    /**
     * 用户头像更新
     * @param userId
     * @param faceUrl
     * @return
     */
    public Appletuser updateUserFace(String userId, String faceUrl);
}
