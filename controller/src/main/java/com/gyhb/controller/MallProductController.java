package com.gyhb.controller;

import com.gyhb.entity.AdminUsers;
import com.gyhb.entity.Appletmallproduct;
import com.gyhb.service.MallProductService;
import com.gyhb.utils.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

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

    @ApiOperation(value="查询所有商品信息",notes = "查询所有商品信息",httpMethod = "GET")
    @GetMapping("/allList")
    public IMOOCJSONResult queryAll(){
        List<Appletmallproduct> lst = mallProductService.queryMallProduct();
        return IMOOCJSONResult.ok(lst) ;
    }

    @ApiOperation(value="查询商品详情",notes = "查询商品详情",httpMethod = "GET")
    @GetMapping("/details")
    public IMOOCJSONResult queryDetails(@RequestParam String id){
        Appletmallproduct lst = mallProductService.queryDetails(id);
        return IMOOCJSONResult.ok(lst) ;
    }
}
