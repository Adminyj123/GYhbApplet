package com.gyhb.controller;

import com.gyhb.entity.Appletmallproduct;
import com.gyhb.service.MallProductService;
import com.gyhb.utils.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "商品", tags = {"商品相关接口"})
@RestController
@RequestMapping("mallProduct")
public class MallProductController {

    @Autowired
    private MallProductService mallProductService;

    @ApiOperation(value="新增商品",notes = "新增商品",httpMethod = "POST")
    @PostMapping("/createMallProduct")
    public IMOOCJSONResult createMallCategory(@RequestBody Appletmallproduct appletmallproduct){
        IMOOCJSONResult res= mallProductService.addMallProduct(appletmallproduct);

        return res;
    }
}
