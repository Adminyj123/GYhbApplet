package com.gyhb.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.gyhb.entity.AdminUsers;
import com.gyhb.entity.bo.AdminUserBO;
import com.gyhb.entity.bo.userLoginBo;
import com.gyhb.service.AdminUsersService;
import com.gyhb.utils.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

/**
 * @author Admin-Yj
 */
@Api(value = "用户信息", tags = {"用户信息相关的api接口"})
@RequestMapping("AddMinUsers")
@RestController
public class AdminUsersController {

    final static Logger logger = LoggerFactory.getLogger(AdminUsersController.class);
    private final AdminUsersService addAdminUsers;

    public AdminUsersController(AdminUsersService addAdminUsers) {
        this.addAdminUsers = addAdminUsers;
    }

    @ApiOperation(value = "新增用户信息", notes = "新增用户信息", httpMethod = "POST")
    @PostMapping("/addUsers")
    public IMOOCJSONResult addUsers(@RequestBody AdminUsers adminUsers) {

        //判断传入的值是否符合规格
        IMOOCJSONResult userRes = checkUser(adminUsers);
        int status = 200;

        if (userRes.getStatus() != status) {
            return userRes;
        }

        return addAdminUsers.addAdminUsers(adminUsers);
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

        int pasLen = 6;

        // 2. 密码长度不能少于6位
        if (password.length() < pasLen) {
            return IMOOCJSONResult.errorMsg("密码长度不能少于6");
        }

        int userLen = 12;

        if (username.length() > userLen) {
            return IMOOCJSONResult.errorMsg("用户名不能太长");
        }

        String mobile = users.getMobile();
        if (StringUtils.isBlank(mobile)) {
            return IMOOCJSONResult.errorMsg("手机号不能为空");
        }

        int mobileLen = 11;
        if (mobile.length() != mobileLen) {
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
        String userPwd = userBO.getUserpwd();

        // 0. 判断用户名和密码必须不为空
        if (StringUtils.isBlank(username) ||
                StringUtils.isBlank(userPwd)) {
            return IMOOCJSONResult.errorMsg("用户名或密码不能为空");
        }

        // 1. 实现登录
        AdminUsers userResult = addAdminUsers.queryUserForLogin(username,
                MD5Utils.getMD5Str(userPwd));

        if (userResult == null) {
            return IMOOCJSONResult.errorMsg("用户名或密码不正确");
        }

        userResult.setUserpwd(null);
        userResult.setSex(null);

        CookieUtils.setCookie(request, response, "user",
                JsonUtils.objectToJson(userResult), true);

        // TODO 生成用户token，存入redis会话

        /*设置超时时间 以秒为单位  此处设置为30分钟*/
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 14 * 24 * 3600);

        String userid = userResult.getUserid();
        String name = userResult.getUsername();

        //将用户id与用户名 存入token
        String token = JWT.create()
                //header
                .withHeader(new HashMap<>(16))
                .withClaim("userid", userid)
                .withClaim("username", name)
                //设置过期时间
                .withExpiresAt(calendar.getTime())
                //  签名用的seCert
                .sign(Algorithm.HMAC256("!34ADAS"));

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
