package com.gyhb.controller;

import com.gyhb.entity.Appletuser;
import com.gyhb.service.AppletUserService;
import com.gyhb.utils.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(value="首页",tags = {"首页展示的相关接口"})
@RestController
@RequestMapping("index")
public class HelloController {

    @Autowired
    private AppletUserService appletUserService;

    @GetMapping("/test")
    public Object hello(){
        return  "hello world";
    }

    @ApiOperation(value="查询用户信息",notes = "查询用户信息",httpMethod = "GET")
    @GetMapping("/queryuser")
    public IMOOCJSONResult queryuser(){

        List<Appletuser> res= appletUserService.queryall();

        return IMOOCJSONResult.ok(res) ;
    }

}
