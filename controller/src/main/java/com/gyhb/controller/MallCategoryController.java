package com.gyhb.controller;

import com.gyhb.entity.Appletfeedback;
import com.gyhb.entity.Appletmallcategory;
import com.gyhb.service.AppletFeedbackService;
import com.gyhb.service.MallCategoryService;
import com.gyhb.utils.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "商城列表", tags = {"商城列表相关接口"})
@RestController
@RequestMapping("mallCategory")
public class MallCategoryController {

    @Autowired
    private MallCategoryService mallCategoryService;

    @ApiOperation(value="新增商城列表",notes = "新增商城列表",httpMethod = "POST")
    @PostMapping("/createMallCategory")
    public IMOOCJSONResult createMallCategory(@RequestBody Appletmallcategory mallcategory){
        IMOOCJSONResult res= mallCategoryService.addMallCategory(mallcategory);

        return res;
    }


}
