package com.gyhb.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.gyhb.entity.Appletuser;
import com.gyhb.entity.bo.AdminUserBO;
import com.gyhb.entity.bo.userLoginBo;
import com.gyhb.utils.utils.*;
import org.springframework.web.bind.annotation.*;

import com.gyhb.entity.AdminUsers;
import com.gyhb.service.AdminUsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

@Api(value = "用户信息", tags = {"用户信息相关的api接口"})
@RequestMapping("AddminUsers")
@RestController
public class AdminUsersController {

    @Autowired
    private AdminUsersService addAdminUsers;

    @ApiOperation(value = "新增用户信息", notes = "新增用户信息", httpMethod = "POST")
    @PostMapping("/addUsers")
    public IMOOCJSONResult addUsers(@RequestBody AdminUsers adminUsers) {

        //判断传入的值是否符合规格
        IMOOCJSONResult userRes = checkUser(adminUsers);

        if (userRes.getStatus() != 200) {
            return userRes;
        }

        IMOOCJSONResult res= addAdminUsers.addAdminUsers(adminUsers);
        return IMOOCJSONResult.ok();
    }

    private IMOOCJSONResult checkUser(AdminUsers users) {

        String username = users.getUsername();
        String password = users.getUserpwd();

        // 0. 判断用户名和密码必须不为空
        if (StringUtils.isBlank(username) ||
                StringUtils.isBlank(password)) {
            return IMOOCJSONResult.errorMsg("用户名或密码不能为空");
        }

        // 1. 查询用户名是否存在
        boolean isExist = addAdminUsers.queryUsernameIsExist(username);
        if (isExist) {
            return IMOOCJSONResult.errorMsg("用户名已经存在");
        }

        // 2. 密码长度不能少于6位
        if (password.length() < 6) {
            return IMOOCJSONResult.errorMsg("密码长度不能少于6");
        }

        if (username.length() > 12) {
            return IMOOCJSONResult.errorMsg("用户名不能太长");
        }

        String mobile = users.getMobile();
        if (StringUtils.isBlank(mobile)) {
            return IMOOCJSONResult.errorMsg("手机号不能为空");
        }
        if (mobile.length() != 11) {
            return IMOOCJSONResult.errorMsg("手机号长度不正确");
        }
        boolean isMobileOk = MobileEmailUtils.checkMobileIsOk(mobile);
        if (!isMobileOk) {
            return IMOOCJSONResult.errorMsg("手机号格式不正确");
        }

        return IMOOCJSONResult.ok();
    }

    @ApiOperation(value = "用户登录", notes = "用户登录", httpMethod = "POST")
    @PostMapping("/login")
    public IMOOCJSONResult login(@RequestBody AdminUserBO userBO,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {

        String username = userBO.getUsername();
        String userpwd = userBO.getUserpwd();

        // 0. 判断用户名和密码必须不为空
        if (StringUtils.isBlank(username) ||
                StringUtils.isBlank(userpwd)) {
            return IMOOCJSONResult.errorMsg("用户名或密码不能为空");
        }

        // 1. 实现登录
        AdminUsers userResult = addAdminUsers.queryUserForLogin(username,
                MD5Utils.getMD5Str(userpwd));

        if (userResult == null) {
            return IMOOCJSONResult.errorMsg("用户名或密码不正确");
        }

        userResult = setNullProperty(userResult);

        CookieUtils.setCookie(request, response, "user",
                JsonUtils.objectToJson(userResult), true);

        // TODO 生成用户token，存入redis会话

        /*设置超时时间 以秒为单位  此处设置为30分钟*/
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 14 * 24 * 3600);

        String userid = userResult.getUserid();
        String name = userResult.getUsername();

        //将用户id与用户名 存入token
        String token = "";
        token = JWT.create()
                .withHeader(new HashMap<>())  //header
                .withClaim("userid", userid)
                .withClaim("username", name)
                .withExpiresAt(calendar.getTime())  //设置过期时间
                .sign(Algorithm.HMAC256("!34ADAS")); //  签名用的secert

        userLoginBo login = new userLoginBo();
        login.setRole(userResult.getRole());
        login.setState(userResult.getState());
        login.setDeptId(userResult.getDeptid());
        login.setRoleList(null);
        login.setToken(token);
        login.setUserId(userResult.getUserid());
        login.setUserEmail(userResult.getUseremail());
        login.setUserName(userResult.getUsername());

        // TODO 同步购物车数据

        return IMOOCJSONResult.ok(login);
    }

    private AdminUsers setNullProperty(AdminUsers userResult) {
        userResult.setUserpwd(null);
        userResult.setSex(null);
        return userResult;
    }

    @ApiOperation(value="查询所有用户信息",notes = "查询所有用户信息",httpMethod = "GET")
    @GetMapping("/allList")
    public IMOOCJSONResult queryAll(){
       List<AdminUsers> lst = addAdminUsers.queryAll();
       if(lst.size()>0){
           for (AdminUsers ls: lst) {
               ls.setUserpwd(null);
           }
       }
        return IMOOCJSONResult.ok(lst) ;
    }

}
