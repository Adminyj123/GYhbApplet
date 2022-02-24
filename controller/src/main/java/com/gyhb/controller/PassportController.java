package com.gyhb.controller;

import com.gyhb.entity.Appletuser;
import com.gyhb.entity.bo.UserBO;
import com.gyhb.entity.bo.UserVo;
import com.gyhb.service.AppletUserService;
import com.gyhb.utils.utils.CookieUtils;
import com.gyhb.utils.utils.IMOOCJSONResult;
import com.gyhb.utils.utils.JsonUtils;
import com.gyhb.utils.utils.MD5Utils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Api(value = "注册登录", tags = {"用于注册登录的相关接口"})
@RestController
@RequestMapping("passport")
public class PassportController {

    @Autowired
    private AppletUserService userService;

    @ApiOperation(value = "微信号是否存在", notes = "微信号是否存在", httpMethod = "GET")
    @GetMapping("/wechatIsExist")
    public IMOOCJSONResult usernameIsExist(@RequestParam String WechatNumber) {

        // 1. 判断微信号不能为空
        if (StringUtils.isBlank(WechatNumber)) {
            return IMOOCJSONResult.errorMsg("微信号不能为空");
        }

        // 2. 查找注册的微信号是否存在
        boolean isExist = userService.queryWechatIsExist(WechatNumber);
        if (isExist) {
            return IMOOCJSONResult.errorMsg("微信号已经存在");
        }

        // 3. 请求成功，微信号没有重复
        return IMOOCJSONResult.ok();
    }

    @ApiOperation(value = "微信用户注册", notes = "微信用户注册", httpMethod = "POST")
    @PostMapping("/regist")
    public IMOOCJSONResult regist(@RequestBody UserVo userBO,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {

        String WechatNumber = userBO.getWechatNumber();
        String password = userBO.getPassword();
        String confirmPwd = userBO.getConfirmPassword();

        // 0. 判断微信用户名和密码必须不为空
        if (StringUtils.isBlank(WechatNumber) ||
                StringUtils.isBlank(password) ||
                StringUtils.isBlank(confirmPwd)) {
            return IMOOCJSONResult.errorMsg("微信用户或密码不能为空");
        }

        // 1. 查询用户名是否存在
        boolean isExist = userService.queryWechatIsExist(WechatNumber);
        if (isExist) {
            return IMOOCJSONResult.errorMsg("微信用户已经存在");
        }

        // 2. 密码长度不能少于6位
        if (password.length() < 6) {
            return IMOOCJSONResult.errorMsg("密码长度不能少于6");
        }

        // 3. 判断两次密码是否一致
        if (!password.equals(confirmPwd)) {
            return IMOOCJSONResult.errorMsg("两次密码输入不一致");
        }

        // 4. 实现注册
        Appletuser userResult = userService.createUser(userBO);

        userResult = setNullProperty(userResult);

        CookieUtils.setCookie(request, response, "user",
                JsonUtils.objectToJson(userResult), true);

        return IMOOCJSONResult.ok();
    }

    @ApiOperation(value = "用户登录", notes = "用户登录", httpMethod = "POST")
    @PostMapping("/login")
    public IMOOCJSONResult login(@RequestBody UserVo userBO,
                                 HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {

        String wechatNumber = userBO.getWechatNumber();
        String password = userBO.getPassword();

        // 0. 判断用户名和密码必须不为空
        if (StringUtils.isBlank(wechatNumber) ||
                StringUtils.isBlank(password)) {
            return IMOOCJSONResult.errorMsg("用户名或密码不能为空");
        }

        // 1. 实现登录
        Appletuser userResult = userService.queryUserForLogin(wechatNumber,
                    MD5Utils.getMD5Str(password));

        if (userResult == null) {
            return IMOOCJSONResult.errorMsg("用户名或密码不正确");
        }

        userResult = setNullProperty(userResult);

        CookieUtils.setCookie(request, response, "user",
                JsonUtils.objectToJson(userResult), true);

        return IMOOCJSONResult.ok(userResult);
    }

    private Appletuser setNullProperty(Appletuser userResult) {
        userResult.setCreatedTime(null);
        userResult.setUpdatedTime(null);
        return userResult;
    }


    @ApiOperation(value = "用户退出登录", notes = "用户退出登录", httpMethod = "POST")
    @PostMapping("/logout")
    public IMOOCJSONResult logout(@RequestParam String userId,
                                  HttpServletRequest request,
                                  HttpServletResponse response) {

        // 清除用户的相关信息的cookie
        CookieUtils.deleteCookie(request, response, "user");

        return IMOOCJSONResult.ok();
    }

}
