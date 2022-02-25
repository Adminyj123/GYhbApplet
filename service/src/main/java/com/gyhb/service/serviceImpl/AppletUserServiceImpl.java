package com.gyhb.service.serviceImpl;

import com.gyhb.entity.Appletpassward;
import com.gyhb.entity.Appletuser;
import com.gyhb.entity.bo.UserBO;
import com.gyhb.entity.bo.UserVo;
import com.gyhb.mapper.AppletpasswardMapper;
import com.gyhb.mapper.AppletuserMapper;
import com.gyhb.service.AppletUserService;
import com.gyhb.utils.utils.MD5Utils;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class AppletUserServiceImpl implements AppletUserService {

    @Autowired
    protected AppletuserMapper appletUserMapper;

    @Autowired
    protected AppletpasswardMapper appletPasswardMapper;

    @Autowired
    private Sid sid;

    /**
     * 根据微信号查询数据
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryWechatIsExist(String WechatNumber) {
        Example userExample = new Example(Appletuser.class);
        Example.Criteria userCriteria = userExample.createCriteria();

        userCriteria.andEqualTo("wechatnumber", WechatNumber);

        Appletuser result = appletUserMapper.selectOneByExample(userExample);

        return result == null ? false : true;
    }

    /**
     * 注册
     */
    @Transactional(propagation = Propagation.REQUIRED)
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


    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Appletuser queryUserForLogin(String wechatNumber, String password) {

        Example userExample = new Example(Appletuser.class);
        Example.Criteria userCriteria = userExample.createCriteria();

        userCriteria.andEqualTo("wechatnumber", wechatNumber);
        userCriteria.andEqualTo("password", password);

        Appletuser result = appletUserMapper.selectOneByExample(userExample);

        return result;
    }


    @Override
    public Appletuser queryByWx(String wechatNumber) {
        Example userExample = new Example(Appletuser.class);
        Example.Criteria userCriteria = userExample.createCriteria();

        userCriteria.andEqualTo("wechatnumber", wechatNumber);
        return appletUserMapper.selectOneByExample(userExample);
    }
}
