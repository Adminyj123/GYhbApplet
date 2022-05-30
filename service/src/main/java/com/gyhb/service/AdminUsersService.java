package com.gyhb.service;

import com.gyhb.entity.AdminUsers;
import com.gyhb.utils.utils.IMOOCJSONResult;

import java.util.List;

/**
 * @author Admin-Yj
 */
public interface AdminUsersService {

    /**
     * 添加用户信息
     * @param adminUsers
     * @return
     */
     IMOOCJSONResult addAdminUsers(AdminUsers adminUsers);

     /**
      * @Description
      * @Author  Yangjie
      * @Date  2022/5/26 10:22
       * @Params [username]
      * @Return boolean
      **/
     boolean queryUsernameIsExist(String username);


     /**
      * @Description
      * @Author  Yangjie
      * @Date  2022/5/26 10:21
      * @Return java.util.List<com.gyhb.entity.AdminUsers>
      **/
     List<AdminUsers> queryAll();

     /**
      * @Description 
      * @Author  YangJie
      * @Date  2022/5/26 16:20
             @Params 
      * @param username: 
      * @param userPwd: 
      * @Return com.gyhb.entity.AdminUsers
      **/
     AdminUsers queryUserForLogin(String username, String userPwd);


}
