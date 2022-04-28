package com.gyhb.service.serviceImpl;

import com.gyhb.entity.AdminUsers;
import com.gyhb.mapper.AdminUsersMapper;
import com.gyhb.service.AdminUsersService;
import com.gyhb.utils.utils.IMOOCJSONResult;
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
public class AdminUsersServiceImpl implements AdminUsersService {

    @Autowired
    private AdminUsersMapper adminUsersMapper;

    @Autowired
    private Sid sid;

    @Transactional(propagation = Propagation.REQUIRED)  //如果存在一个事务，则支持当前事务。如果没有事务则开启。
    @Override
    public IMOOCJSONResult addAdminUsers(AdminUsers adminUsers) {
        //id
        String userid = sid.nextShort();

        AdminUsers user = new AdminUsers();
        //设置用户表的id
        user.setUserid(userid);
        user.setUsername(adminUsers.getUsername());

        try {
            String pass = MD5Utils.getMD5Str(adminUsers.getUserpwd());
            user.setUserpwd(pass);
        } catch (Exception e) {
            e.printStackTrace();
        }

        user.setUseremail(adminUsers.getUseremail());
        user.setMobile(adminUsers.getMobile());
        user.setSex(adminUsers.getSex());
        user.setDeptid(adminUsers.getDeptid());
        user.setJob(adminUsers.getJob());
        user.setState(adminUsers.getState());
        user.setRole(adminUsers.getRole());
        user.setRolelist(adminUsers.getRolelist());
        Date date = new Date();
        user.setCreatetime(date);
        user.setUpdatetime(date);

        int i = adminUsersMapper.insert(user);
        if (i>0){
            return IMOOCJSONResult.ok();
        }else {
            return IMOOCJSONResult.errorMsg("保存数据失败!");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUsernameIsExist(String username) {

        Example userExample = new Example(AdminUsers.class);
        Example.Criteria userCriteria = userExample.createCriteria();

        userCriteria.andEqualTo("username", username);

        AdminUsers result = adminUsersMapper.selectOneByExample(userExample);

        return result == null ? false : true;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public AdminUsers queryUserForLogin(String username, String userpwd) {

        Example userExample = new Example(AdminUsers.class);
        Example.Criteria userCriteria = userExample.createCriteria();

        userCriteria.andEqualTo("username", username);
        userCriteria.andEqualTo("userpwd", userpwd);

        AdminUsers result = adminUsersMapper.selectOneByExample(userExample);

        return result;
    }

    @Override
    public List<AdminUsers> queryAll() {
        List<AdminUsers> res = adminUsersMapper.selectAll();
        return res;
    }


}
