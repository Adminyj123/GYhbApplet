package com.gyhb.service;

import com.gyhb.entity.AdminUsers;
import com.gyhb.utils.utils.IMOOCJSONResult;

import java.util.List;

public interface AdminUsersService {

    /**
     * 添加用户信息
     * @param adminUsers
     */
    public IMOOCJSONResult addAdminUsers(AdminUsers adminUsers);

    /**
     * 查询用户名是否重复
     * @param username
     */
    public boolean queryUsernameIsExist(String username);

    /**
     * 登录
     * @param username
     * @param userpwd
     */
    public AdminUsers queryUserForLogin(String username,String userpwd);

    /**
     * 查询所有
     */
    public List<AdminUsers> queryAll();

}
