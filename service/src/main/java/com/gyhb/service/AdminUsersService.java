package com.gyhb.service;

import com.gyhb.entity.AdminUsers;
import com.gyhb.utils.utils.IMOOCJSONResult;

import java.util.List;

public interface AdminUsersService {

    /**
     * 添加用户信息
     */
     IMOOCJSONResult addAdminUsers(AdminUsers adminUsers);

    /**
     * 查询用户名是否重复
     */
     boolean queryUsernameIsExist(String username);

    /**
     * 登录
     */
     AdminUsers queryUserForLogin(String username,String userPwd);

    /**
     * 查询所有
     */
     List<AdminUsers> queryAll();

}
