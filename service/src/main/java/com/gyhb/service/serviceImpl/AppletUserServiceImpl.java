package com.gyhb.service.serviceImpl;

import com.gyhb.entity.Appletuser;
import com.gyhb.entity.bo.UserInfoVo;
import com.gyhb.entity.bo.UserVo;
import com.gyhb.mapper.AppletpasswardMapper;
import com.gyhb.mapper.AppletuserMapper;
import com.gyhb.service.AppletUserService;
import com.gyhb.utils.utils.JsonUtils;
import com.gyhb.utils.utils.MD5Utils;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

@Service
public class AppletUserServiceImpl implements AppletUserService {

    protected final AppletuserMapper appletUserMapper;

    protected final AppletpasswardMapper appletPasswardMapper;

    private final Sid sid;

    public AppletUserServiceImpl(AppletuserMapper appletUserMapper, AppletpasswardMapper appletPasswardMapper, Sid sid) {
        this.appletUserMapper = appletUserMapper;
        this.appletPasswardMapper = appletPasswardMapper;
        this.sid = sid;
    }


    /**
     * 根据微信号查询数据
     */
    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    @Override
    public boolean queryWechatIsExist(String WechatNumber) {
        Example userExample = new Example(Appletuser.class);
        Example.Criteria userCriteria = userExample.createCriteria();

        userCriteria.andEqualTo("wechatnumber", WechatNumber);

        Appletuser result = appletUserMapper.selectOneByExample(userExample);

        return result != null;
    }

    /**
     * 注册
     */
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public Appletuser createUser(UserVo userBO) {
        //生产id
        String userId = sid.nextShort();


        //密码表
//        Appletpassward password = new Appletpassward();
        //用户表
        Appletuser user = new Appletuser();
        //设置用户表的id
        user.setId(userId);
        user.setWechatnumber(userBO.getWechatNumber());

        try {
            String pass = MD5Utils.getMD5Str(userBO.getPassword());
            user.setPassword(pass);
        } catch (Exception e) {
            e.printStackTrace();
        }


        //用户信息
        //设置用户表的用户名
//        user.setName(userBO.getName());
//        //设置用户表的年龄
//        user.setAge(userBO.getAge());
//        user.setSex(userBO.getSex());
//        user.setIdcard(userBO.getIdCard());
//        user.setNativeplace(userBO.getNativePlace());
//        user.setNickname(userBO.getNickname());
//        user.setWechatnumber(userBO.getWechatNumber());
//        user.setTelephone(userBO.getTelephone());
//        user.setAvatarurl(userBO.getAvatarUrl());
//        user.setDefaulturl("");
//        user.setValidflag("0");
//        user.setFlag("0");
//        user.setCreatedTime(new Date());
//        user.setUpdatedTime(new Date());

        appletUserMapper.insert(user);
//        appletPasswardMapper.insert(password);

        return user;
    }


    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    @Override
    public Appletuser queryUserForLogin(String wechatNumber, String password) {

        Example userExample = new Example(Appletuser.class);
        Example.Criteria userCriteria = userExample.createCriteria();

        userCriteria.andEqualTo("wechatnumber", wechatNumber);
        userCriteria.andEqualTo("password", password);

        return appletUserMapper.selectOneByExample(userExample);
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public Appletuser addUser(String res,String openid) {
        if(StringUtils.isNotBlank(res)){
            UserInfoVo userInfo = JsonUtils.jsonToPojo(res,UserInfoVo.class);

            Appletuser appletuser = new Appletuser();
            appletuser.setId(sid.nextShort());
            appletuser.setNickname(userInfo.getNickName());
            appletuser.setWechatnumber(openid);
            appletuser.setSex(userInfo.getGender());
            appletuser.setAvatarurl(userInfo.getAvatarUrl());
            //国家
            appletuser.setAddinfo0(userInfo.getCountry());
            //城市
            appletuser.setAddinfo1(userInfo.getCity());
            //省份
            appletuser.setAddinfo2(userInfo.getProvince());
//            appletuser.setAddinfo3(userInfo.getUnionId());
            appletuser.setAddinfo4(userInfo.getWatermark().getAppid());
            appletuser.setAddinfo5(userInfo.getWatermark().getTimestamp());
            appletuser.setValidflag("0");
            appletuser.setFlag("0");
            appletuser.setCreatedTime(new Date());

            appletUserMapper.insert(appletuser);
            return appletuser;
        }else{
            return new Appletuser();
        }
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public Appletuser updateUserFace(String userId, String faceUrl) {
        Appletuser updateUser = new Appletuser();
        updateUser.setId(userId);
        updateUser.setAvatarurl(faceUrl);
        updateUser.setUpdatedTime(new Date());

        appletUserMapper.updateByPrimaryKeySelective(updateUser);

        return appletUserMapper.selectByPrimaryKey(userId);

    }


    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    @Override
    public Appletuser queryByWx(String wechatNumber) {
        Example userExample = new Example(Appletuser.class);
        Example.Criteria userCriteria = userExample.createCriteria();

        userCriteria.andEqualTo("wechatnumber", wechatNumber);
        return appletUserMapper.selectOneByExample(userExample);
    }
}
