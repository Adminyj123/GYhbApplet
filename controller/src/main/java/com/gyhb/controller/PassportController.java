package com.gyhb.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.gyhb.entity.Appletuser;
import com.gyhb.entity.bo.UserVo;
import com.gyhb.service.AppletUserService;
import com.gyhb.utils.utils.*;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Key;
import java.security.Security;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;

@Api(value = "注册登录", tags = {"用于注册登录的相关接口"})
@RestController
@RequestMapping("passport")
public class PassportController {

    @Autowired
    private AppletUserService userService;

    @Autowired
    private RedisOperator redis;

    @Autowired
    private Sid sid;

    //算法名
    private static final String KEY_ALGORITHM = "AES";//填充
    private static final String ALGORITHM_STR = "AES/CBC/PKCS7Padding";//密钥格式
    private static final String KEY_OPENID_REDIS = "OpenId";//REDIS 中 openid的文件
    private static final String KEY_SESSIONKEY_REDIS = "SessionKey";//REDIS 中 SessionKey 文件
    private static Key key;
    private static Cipher cipher;

    @ApiIgnore
    @ApiOperation(value = "注册获取token", notes = "注册获取token", httpMethod = "GET")
    @GetMapping("/code2Session")
    public IMOOCJSONResult register(
            @ApiParam(name = "appid", value = "小程序appId", required = true)
            @RequestParam String appid,
            @ApiParam(name = "secret", value = "小程序 appSecret", required = true)
            @RequestParam String secret,
            @ApiParam(name = "js_code", value = "登录时获取的 code", required = true)
            @RequestParam String js_code,
            @ApiParam(name = "grant_type", value = "授权类型，此处只需填写 authorization_code", required = true)
            @RequestParam String grant_type
    ) throws HttpException, IOException {
        //测试用
        // String url = hburl("wx43d8f28b72763ad8","303881137418a15d95d3c53958e5ee0f",js_code,"authorization_code");

        // 正式使用
        String url = hburl(appid, secret, js_code, grant_type);
        HttpClient httpClient = new HttpClient();
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(15000);
        GetMethod method = new GetMethod(url);
        method.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 6000);
        method.addRequestHeader("Content-Type", "application/json");
        httpClient.executeMethod(method);
        String result = method.getResponseBodyAsString();

        JSONObject jsonObject = new JSONObject();
        JSONObject res = JSONObject.parseObject(result);
        //获取errcode的值
        String errcode = res.getString("errcode");
        String result_openid = res.getString("openid");
        String result_key = res.getString("session_key");
        String errmsg = res.getString("errmsg");

        /*当errcode == “0” 时说明请求成功 */
        if (StringUtils.isNoneBlank(result_key) && StringUtils.isNotBlank(result_openid)) {
            /*设置超时时间 以秒为单位  此处设置为30分钟*/
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.SECOND, 14 * 24 * 3600);

            String token = "";
            token = JWT.create()
                    .withHeader(new HashMap<>())  //header
                    .withClaim("openid", result_openid)
//                    .withClaim("sessionkey",result_key)
                    .withExpiresAt(calendar.getTime())  //设置过期时间
                    .sign(Algorithm.HMAC256("!34ADAS")); //  签名用的secert

//            String  time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());
//            String  time = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(calendar.getTime());

            redis.set(KEY_OPENID_REDIS + ":" + result_openid, result_key);

            jsonObject.put("token", token);
            jsonObject.put("user", "user");
            jsonObject.put("time", calendar.getTime().getTime());
            //关闭HttpClient
            method.releaseConnection();
            return IMOOCJSONResult.ok(jsonObject);
        } else { //请求失败
            jsonObject.put("errcode", errcode);
            jsonObject.put("errmsg", errmsg);
            //关闭HttpClient
            method.releaseConnection();
            return new IMOOCJSONResult(201, "请求错误！", jsonObject);
        }
    }


    @ApiIgnore
    @ApiOperation(value = "登录获取用户信息", notes = "登录获取用户信息", httpMethod = "GET")
    @GetMapping("/logintest")
    public IMOOCJSONResult logintest(
            @ApiParam(name = "token", value = "token", required = true)
            @RequestParam String token,
            @ApiParam(name = "encryptDataB64", value = "encryptDataB64", required = true)
            @RequestParam String encryptDataB64,
            @ApiParam(name = "ivB64", value = "ivB64", required = true)
            @RequestParam String ivB64
    ) {
        JWTVerifier Jtverifier = JWT.require(Algorithm.HMAC256("!34ADAS")).build();
        DecodedJWT jwt = Jtverifier.verify(token);
        Claim openid = jwt.getClaim("openid");
        String open = openid.asString();

        String sessionKey = redis.get(open);
        if (StringUtils.isNotBlank(sessionKey)) {
            String userxx = redis.get(sessionKey);
            if (StringUtils.isNotBlank(userxx)) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("token", token);
                jsonObject.put("userinfo", JsonUtils.objectToJson(userxx));
                return IMOOCJSONResult.ok(jsonObject);
            } else {
                String res = new String(decryptofDiyIV(
                        Base64.decode(encryptDataB64),
                        Base64.decode(sessionKey),
                        Base64.decode(ivB64)
                ));

                //这里需要将用户信息保存到数据库
                Appletuser userinfo = userService.addUser(res);
                redis.set(KEY_SESSIONKEY_REDIS + ":" + sessionKey, JsonUtils.objectToJson(userinfo));

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("token", token);
                jsonObject.put("userinfo", JsonUtils.objectToJson(res));
                return IMOOCJSONResult.ok(jsonObject);
            }
        } else {
            return IMOOCJSONResult.errorMsg("登录失败!");
        }
    }


    @ApiOperation(value = "注册登录", notes = "注册登录", httpMethod = "GET")
    @GetMapping("/login")
    public IMOOCJSONResult login(
            @ApiParam(name = "jsCode", value = "登录时获取的 js_code", required = true)
            @RequestParam String jsCode,
            @ApiParam(name = "encryptData", value = "encryptData", required = true)
            @RequestParam String encryptData,
            @ApiParam(name = "iv", value = "iv", required = true)
            @RequestParam String iv,
            @ApiParam(name = "inviteCode", value = "用户邀请码", required = false)
            @RequestParam String inviteCode
    ) throws HttpException, IOException {

        // 正式使用
        //根据jscode 获取sessionkey和openid
        String url = hburl("wx43d8f28b72763ad8", "303881137418a15d95d3c53958e5ee0f", jsCode, "authorization_code");
        HttpClient httpClient = new HttpClient();
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(15000);
        GetMethod method = new GetMethod(url);
        method.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 6000);
        method.addRequestHeader("Content-Type", "application/json");
        httpClient.executeMethod(method);
        String result = method.getResponseBodyAsString();

        JSONObject jsonObject = new JSONObject();
        JSONObject res = JSONObject.parseObject(result);
        //获取errcode的值
        String errcode = res.getString("errcode");
        String result_openid = res.getString("openid");
        String result_key = res.getString("session_key");
        String errmsg = res.getString("errmsg");

        /*当errcode == “0” 时说明请求成功 */
        if (StringUtils.isNoneBlank(result_key) && StringUtils.isNotBlank(result_openid)) {

            String redis_userinfo = redis.get(KEY_OPENID_REDIS+":"+ result_openid);

            //如果能获取到userinfo 则表示已经注册过，能直接获取到用户信息
            if(StringUtils.isNotBlank(redis_userinfo)){
                jsonObject.put("userinfo", redis_userinfo);
            }else{  //获取不到用户信息
                //获取用户信息
                String resl = new String(decryptofDiyIV(
                        Base64.decode(encryptData),
                        Base64.decode(result_key),
                        Base64.decode(iv)
                ));

                //这里需要将用户信息保存到数据库
                Appletuser userinfo = userService.addUser(resl);
                redis.set( KEY_OPENID_REDIS+":"+ result_openid,JsonUtils.objectToJson(userinfo));
                jsonObject.put("userinfo", JsonUtils.objectToJson(userinfo));
            }


            /*设置超时时间 以秒为单位  此处设置为30分钟*/
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.SECOND, 14 * 24 * 3600);

            //将小程序唯一标识openid包装成toke
            String token = "";
            token = JWT.create()
                    .withHeader(new HashMap<>())  //header
                    .withClaim("openid", result_openid)
                    .withExpiresAt(calendar.getTime())  //设置过期时间
                    .sign(Algorithm.HMAC256("!34ADAS")); //  签名用的secert

            jsonObject.put("token", token);
            jsonObject.put("user", "user");
            jsonObject.put("time", calendar.getTime().getTime());
            //关闭HttpClient
            method.releaseConnection();
            return IMOOCJSONResult.ok(jsonObject);
        } else { //请求失败
            jsonObject.put("errcode", errcode);
            jsonObject.put("errmsg", errmsg);
            //关闭HttpClient
            method.releaseConnection();
            return new IMOOCJSONResult(201, "请求错误！", jsonObject);
        }
    }

    private String hburl(String appid, String secret, String js_code, String grant_type) {
        String url1 = "https://api.weixin.qq.com/sns/jscode2session?appid=";
        String url2 = appid + "&secret=";
        String url3 = secret + "&js_code=";
        String url4 = js_code + "&grant_type=";
        String url5 = grant_type;

        return url1 + url2 + url3 + url4 + url5;
    }


//    @ApiOperation(value = "获取AccessToken", notes = "获取小程序全局唯一后台接口调用凭据", httpMethod = "GET")
//    @GetMapping("/getAccessToken")
//    public IMOOCJSONResult getAccessToken(
//            @ApiParam(name = "grant_type", value = "填写 client_credential", required = true)
//            @RequestParam String grant_type,
//            @ApiParam(name = "appid", value = "小程序唯一凭证，即 AppID", required = true)
//            @RequestParam String appid,
//            @ApiParam(name = "secret", value = "小程序唯一凭证密钥，即 AppSecret", required = true)
//            @RequestParam String secret
//    )  throws HttpException , IOException {
//
//        String url = hburlToken(appid,secret,grant_type);
//        HttpClient httpClient =new HttpClient();
//        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(15000);
//        GetMethod method = new GetMethod(url);
//        method.getParams().setParameter(HttpMethodParams.SO_TIMEOUT,6000);
//        method.addRequestHeader("Content-Type","application/json");
//        httpClient.executeMethod(method);
//        Object result = method.getResponseBodyAsString();
//        method.releaseConnection();
//
//        return IMOOCJSONResult.ok(result);
//    }
//
//    private String hburlToken(String appid,String secret,String grant_type){
//
//        String url1 = "https://api.weixin.qq.com/cgi-bin/token?grant_type=";
//        String url2 = grant_type+"&appid=";
//        String url3 = appid+"&secret=";
//        String url4 = secret;
//
////        System.out.println(url1+url2+url3+url4);
//        return url1+url2+url3+url4;
//    }

    @ApiOperation(value = "刷新token", notes = "刷新token", httpMethod = "GET")
    @GetMapping("/flushToke")
    public IMOOCJSONResult flush(
            @ApiParam(name = "token", value = "token", required = true)
            @RequestParam String token
    ) {
        JSONObject jsonObject = new JSONObject();
        if (StringUtils.isNoneBlank(token)) {
            /*设置超时时间 以秒为单位  此处设置为30分钟*/
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.SECOND, 14 * 24 * 3600);

            JWTVerifier Jtverifier = JWT.require(Algorithm.HMAC256("!34ADAS")).build();
            DecodedJWT jwt = Jtverifier.verify(token);
            Claim openid = jwt.getClaim("openid");

            String open = openid.asString();

            token = JWT.create()
                    .withHeader(new HashMap<>())  //header
                    .withClaim("openid", open)
                    .withExpiresAt(calendar.getTime())  //设置过期时间
                    .sign(Algorithm.HMAC256("!34ADAS")); //  签名用的secert

            jsonObject.put("token", token);
            jsonObject.put("time", calendar.getTime().getTime());

            return IMOOCJSONResult.ok(jsonObject);
        } else {
            return IMOOCJSONResult.errorMsg("token不能为空！");
        }

    }

    @ApiIgnore
    @ApiOperation(value = "测试解析token", notes = "解析token", httpMethod = "GET")
    @GetMapping("/jxsj")
    public IMOOCJSONResult verify(
            @ApiParam(name = "token", value = "token", required = true)
            @RequestParam String token
    ) {
        JWTVerifier Jtverifier = JWT.require(Algorithm.HMAC256("!34ADAS")).build();
        DecodedJWT jwt = Jtverifier.verify(token);
        Claim openid = jwt.getClaim("openid");
        String open = openid.asString();
        return IMOOCJSONResult.ok(open);
    }

    @ApiIgnore
    @ApiOperation(value = "测试用来获取sessionkey", notes = "测试用来获取sessionkey", httpMethod = "GET")
    @GetMapping("/getopenid")
    public IMOOCJSONResult seseion(
            @ApiParam(name = "js_code", value = "登录时获取的 code", required = true)
            @RequestParam String js_code
    ) throws HttpException, IOException {
        //测试用
        String url = hburl("wx43d8f28b72763ad8", "303881137418a15d95d3c53958e5ee0f", js_code, "authorization_code");

        // 正式使用
//        String url = hburl(appid,secret,js_code,grant_type);
        HttpClient httpClient = new HttpClient();
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(15000);
        GetMethod method = new GetMethod(url);
        method.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 6000);
        method.addRequestHeader("Content-Type", "application/json");
        httpClient.executeMethod(method);
        String result = method.getResponseBodyAsString();

        JSONObject jsonObject = new JSONObject();
        JSONObject res = JSONObject.parseObject(result);
        //获取errcode的值
        String errcode = res.getString("errcode");
        String result_openid = res.getString("openid");
        String result_key = res.getString("session_key");
        String errmsg = res.getString("errmsg");

        return IMOOCJSONResult.ok(result_key);
    }


    @ApiIgnore
    @ApiOperation(value = "测试用来获取userinfo", notes = "测试用来获取userinfo", httpMethod = "GET")
    @GetMapping("/testuserinfo")
    public IMOOCJSONResult decryptData(
            @ApiParam(name = "encryptDataB64", value = "encryptDataB64", required = true)
            @RequestParam String encryptDataB64,
            @ApiParam(name = "sessionKeyB64", value = "小程序 sessionKeyB64", required = true)
            @RequestParam String sessionKeyB64,
            @ApiParam(name = "ivB64", value = "ivB64", required = true)
            @RequestParam String ivB64) {
        //将传递过来的数据用base64先行解密

        JSONObject jsonObject = new JSONObject();
        String redis_userinfo = redis.get(KEY_OPENID_REDIS+":"+ "test");

        //如果能获取到userinfo 则表示已经注册过，能直接获取到用户信息
        if(StringUtils.isNotBlank(redis_userinfo)){
            jsonObject.put("test", redis_userinfo);
        }else{  //获取不到用户信息
            //获取用户信息
            String resl = new String(decryptofDiyIV(
                    Base64.decode(encryptDataB64),
                    Base64.decode(sessionKeyB64),
                    Base64.decode(ivB64)
            ));

            //这里需要将用户信息保存到数据库
            Appletuser userinfo = userService.addUser(resl);
            redis.set( KEY_OPENID_REDIS+":"+ "test",JsonUtils.objectToJson(userinfo));
            jsonObject.put("userinfo", JsonUtils.objectToJson(userinfo));
        }


//        String result = new String(new String(
//                decryptofDiyIV(
//                        Base64.decode(encryptDataB64),
//                        Base64.decode(sessionKeyB64),
//                        Base64.decode(ivB64)
//                ))
//        );
//        JSONObject res = JSON.parseObject(result);

        return IMOOCJSONResult.ok(jsonObject);
    }

    /***
     * 解密方法
     * @param encryptedData 要解密的字符串
     * @param keyBytes 解密密钥
     * @param ivs 自定义对称解密算法初始向量iv
     * @return 解密后的字节数组
     * */
    private static byte[] decryptofDiyIV(byte[] encryptedData, byte[] keyBytes, byte[] ivs) {
        byte[] encryptedText = null;
        init(keyBytes);
        try {
            cipher.init(cipher.DECRYPT_MODE, key, new IvParameterSpec(ivs));
            encryptedText = cipher.doFinal(encryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedText;
    }

    private static void init(byte[] keyBytes) {
        //如果密钥不足16位，那么就补足。这个if中的内容很重要
        int base = 16;
        if (keyBytes.length % base != 0) {
            int groups = keyBytes.length / base + (keyBytes.length % base != 0 ? 1 : 0);
            byte[] temp = new byte[groups * base];
            Arrays.fill(temp, (byte) 0);
            System.arraycopy(keyBytes, 0, temp, 0, keyBytes.length);
            keyBytes = temp;
        }
        // 初始化BouncyCastleProvider()
        Security.addProvider(new BouncyCastleProvider());//转化成AVA的密钥格式
        key = new SecretKeySpec(keyBytes, KEY_ALGORITHM);
        try {
            // 初始化cipher
            cipher = Cipher.getInstance(ALGORITHM_STR, "BC");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @ApiIgnore
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

    @ApiIgnore
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

    @ApiIgnore
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


    @ApiIgnore
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
