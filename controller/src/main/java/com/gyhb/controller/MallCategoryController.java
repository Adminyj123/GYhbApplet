package com.gyhb.controller;

import com.gyhb.entity.Appletmallcategory;
import com.gyhb.service.MallCategoryService;
import com.gyhb.utils.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "商城列表", tags = {"商城列表相关接口"})
@RestController
@RequestMapping("mallCategory")
public class MallCategoryController {

    public final MallCategoryService mallCategoryService;

    public MallCategoryController(MallCategoryService mallCategoryService){
        this.mallCategoryService = mallCategoryService;
    }

    @ApiOperation(value="新增商城列表",notes = "新增商城列表",httpMethod = "POST")
    @PostMapping("/createMallCategory")
    public IMOOCJSONResult createMallCategory(@RequestBody Appletmallcategory mallCategory){
        return mallCategoryService.addMallCategory(mallCategory);
    }

    @ApiOperation(value="查询商城列表",notes = "查询商城列表",httpMethod = "GET")
    @GetMapping("/queryMallCategory")
    public List<Appletmallcategory> queryMallCategory(){
        return mallCategoryService.queryMallCategory();
    }


}
