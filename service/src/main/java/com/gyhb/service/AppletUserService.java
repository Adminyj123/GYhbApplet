package com.gyhb.service;

import com.gyhb.entity.Appletuser;
import com.gyhb.entity.bo.UserVo;

/**
 * @author YangJie
 * @date 2022/5/30 11:24
*/
public interface AppletUserService {

    /**
     * 判断微信号是否存在
     * @param WechatNumber 微信号
     * @return boolean
     */
     boolean queryWechatIsExist(String WechatNumber);

    /**
     * 注册微信用户
     * @param userBO 用户bo
     * @return Appletuser
     */
     Appletuser createUser(UserVo userBO);

    /**
     * 查询微信用户信息
     * @param wechatNumber 微信号
     * @return Appletuser
     */
     Appletuser queryByWx(String wechatNumber);

    /**
     * 登录查询用户
     * @param wechatNumber 微信号
     * @param md5Str 解密
     * @return Appletuser
     */
    Appletuser queryUserForLogin(String wechatNumber, String md5Str);

    /**
     * 登录查询用户
     * @param res res
     * @param openid openid
     * @return Appletuser
     */
      Appletuser addUser(String res,String openid);

    /**
     * 用户头像更新
     * @param userId userId
     * @param faceUrl faceUrl
     * @return Appletuser
     */
     Appletuser updateUserFace(String userId, String faceUrl);
}
