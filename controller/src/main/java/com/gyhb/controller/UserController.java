package com.gyhb.controller;

import com.gyhb.entity.Appletuser;
import com.gyhb.resource.FileUpload;
import com.gyhb.service.AppletUserService;
import com.gyhb.utils.utils.DateUtil;
import com.gyhb.utils.utils.IMOOCJSONResult;
import com.gyhb.utils.utils.RedisOperator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Api(value="用户信息",tags = {"用户信息的相关接口"})
@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private AppletUserService userService;

    @Autowired
    private FileUpload fileUpload;

    @ApiIgnore
    @ApiOperation(value="根据微信号查询用户信息",notes = "根据微信号查询用户信息",httpMethod = "GET")
    @GetMapping("/queryUserByWx")
    public IMOOCJSONResult queryUser(@RequestParam String wechatNumber){
        Appletuser res= userService.queryByWx(wechatNumber);
        return IMOOCJSONResult.ok(res) ;
    }

    @ApiIgnore
    @ApiOperation(value="修改用户信息",notes = "修改用户信息",httpMethod = "POST")
    @GetMapping("/updateUser")
    public IMOOCJSONResult updateUser(@RequestBody Appletuser appletuser){
        if (StringUtils.isBlank(appletuser.getId())) {
            return IMOOCJSONResult.errorMsg("修改用户信息错误：Id不能为空");
        }

        //判断传入的值是否符合规格
        IMOOCJSONResult userRes = checkUser(appletuser);

        if (userRes.getStatus() != 200) {
            return userRes;
        }

//        Appletuser res= userService.queryByWx(appletuser);

        return IMOOCJSONResult.ok();
    }

    @ApiOperation(value = "用户头像修改", notes = "用户头像修改", httpMethod = "GET")
    @PostMapping("uploadFace")
    public IMOOCJSONResult uploadFace(
            @ApiParam(name = "userId", value = "用户id", required = true)
            @RequestParam String userId,
            @ApiParam(name = "file", value = "用户头像", required = true)
                    MultipartFile file,
            HttpServletRequest request, HttpServletResponse response) {

        // 定义头像保存的地址
        String fileSpace = fileUpload.getImageUserFaceLocation();
        // 在路径上为每一个用户增加一个userid，用于区分不同用户上传
        String uploadPathPrefix = File.separator + userId;

        // 开始文件上传
        if (file != null) {
            FileOutputStream fileOutputStream = null;
            try {
                // 获得文件上传的文件名称
                String fileName = file.getOriginalFilename();

                if (StringUtils.isNotBlank(fileName)) {

                    // 文件重命名  imooc-face.png -> ["imooc-face", "png"]
                    String fileNameArr[] = fileName.split("\\.");

                    // 获取文件的后缀名
                    String suffix = fileNameArr[fileNameArr.length - 1];

                    if (!suffix.equalsIgnoreCase("png") &&
                            !suffix.equalsIgnoreCase("jpg") &&
                            !suffix.equalsIgnoreCase("jpeg") ) {
                        return IMOOCJSONResult.errorMsg("图片格式不正确！");
                    }

                    // face-{userid}.png
                    // 文件名称重组 覆盖式上传，增量式：额外拼接当前时间
                    String newFileName = "face-" + userId + "." + suffix;

                    // 上传的头像最终保存的位置
                    String finalFacePath = fileSpace + uploadPathPrefix + File.separator + newFileName;
                    // 用于提供给web服务访问的地址
                    uploadPathPrefix += ("/" + newFileName);

                    File outFile = new File(finalFacePath);
                    if (outFile.getParentFile() != null) {
                        // 创建文件夹
                        outFile.getParentFile().mkdirs();
                    }

                    // 文件输出保存到目录
                    fileOutputStream = new FileOutputStream(outFile);
                    InputStream inputStream = file.getInputStream();
                    IOUtils.copy(inputStream, fileOutputStream);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fileOutputStream != null) {
                        fileOutputStream.flush();
                        fileOutputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } else {
            return IMOOCJSONResult.errorMsg("文件不能为空！");
        }

        // 获取图片服务地址
        String imageServerUrl = fileUpload.getImageServerUrl();

        // 由于浏览器可能存在缓存的情况，所以在这里，我们需要加上时间戳来保证更新后的图片可以及时刷新
        String finalUserFaceUrl = imageServerUrl + uploadPathPrefix
                + "?t=" + DateUtil.getCurrentDateString(DateUtil.DATE_PATTERN);

        // 更新用户头像到数据库
        Appletuser userResult = userService.updateUserFace(userId, finalUserFaceUrl);

        return IMOOCJSONResult.ok();
    }

















    private IMOOCJSONResult checkUser(Appletuser appletuser) {
//        String receiver = addressBO.getReceiver();
//        if (StringUtils.isBlank(receiver)) {
//            return IMOOCJSONResult.errorMsg("收货人不能为空");
//        }
//        if (receiver.length() > 12) {
//            return IMOOCJSONResult.errorMsg("收货人姓名不能太长");
//        }
//
//        String mobile = addressBO.getMobile();
//        if (StringUtils.isBlank(mobile)) {
//            return IMOOCJSONResult.errorMsg("收货人手机号不能为空");
//        }
//        if (mobile.length() != 11) {
//            return IMOOCJSONResult.errorMsg("收货人手机号长度不正确");
//        }
//        boolean isMobileOk = MobileEmailUtils.checkMobileIsOk(mobile);
//        if (!isMobileOk) {
//            return IMOOCJSONResult.errorMsg("收货人手机号格式不正确");
//        }
//
//        String province = addressBO.getProvince();
//        String city = addressBO.getCity();
//        String district = addressBO.getDistrict();
//        String detail = addressBO.getDetail();
//        if (StringUtils.isBlank(province) ||
//                StringUtils.isBlank(city) ||
//                StringUtils.isBlank(district) ||
//                StringUtils.isBlank(detail)) {
//            return IMOOCJSONResult.errorMsg("收货地址信息不能为空");
//        }

        return IMOOCJSONResult.ok();
    }

    @Autowired
    private RedisOperator redisOperator;

    @ApiIgnore
    @ApiOperation(value="测试redis",notes = "测试redis",httpMethod = "GET")
    @GetMapping("/getredis")
    public IMOOCJSONResult testRedis(@RequestParam String key){
        return  IMOOCJSONResult.ok(redisOperator.get(key));

    }

}
