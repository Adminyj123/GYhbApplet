package com.gyhb.controller;

import com.gyhb.entity.Appletmallproduct;
import com.gyhb.service.MallProductService;
import com.gyhb.utils.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "商品", tags = {"商品相关接口"})
@RestController
@RequestMapping("mallProduct")
public class MallProductController {

    public final MallProductService mallProductService;

    public MallProductController(MallProductService mallProductService) {
        this.mallProductService = mallProductService;
    }

    @ApiOperation(value="新增商品",notes = "新增商品",httpMethod = "POST")
    @PostMapping("/createMallProduct")
    public IMOOCJSONResult createMallCategory(@RequestBody Appletmallproduct appletmallproduct){
        return mallProductService.addMallProduct(appletmallproduct);
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

    @ApiOperation(value = "修改商品信息", notes = "修改商品信息", httpMethod = "POST")
    @PostMapping("/update")
    public IMOOCJSONResult update(@RequestBody Appletmallproduct appletmallproduct) {

        if (StringUtils.isBlank(appletmallproduct.getId())) {
            return IMOOCJSONResult.errorMsg("Id不能为空");
        }

        IMOOCJSONResult checkRes = checkAppletMall(appletmallproduct);
        if (checkRes.getStatus() != 200) {
            return checkRes;
        }

        return mallProductService.updateMallProduct(appletmallproduct);
    }

    private IMOOCJSONResult checkAppletMall(Appletmallproduct p){
        String name = p.getProductname();
        if (StringUtils.isBlank(name)) {
            return IMOOCJSONResult.errorMsg("商品名称不能为空!");
        }

        String amount = p.getAmount().toString();
        if(amount == null || amount.equals("0")|| amount.equals("")){
            return IMOOCJSONResult.errorMsg("商品新价格不能为空!");
        }

        String oldAmount = p.getOldamount().toString();
        if(oldAmount == null|| oldAmount.equals("0")|| oldAmount.equals("") ){
            return IMOOCJSONResult.errorMsg("商品老价格不能为空!");
        }

        String payAmount = p.getPayamount().toString();
        if(payAmount == null || payAmount.equals("0")|| payAmount.equals("") ){
            return IMOOCJSONResult.errorMsg("商品实际支付价格不能为空!");
        }

        String coverImg = p.getCoverimg();
        if (StringUtils.isBlank(coverImg)){
            return IMOOCJSONResult.errorMsg("封面图不能为空!");
        }

        return IMOOCJSONResult.ok();
    }

    @ApiOperation(value = "删除商品", notes = "删除商品", httpMethod = "POST")
    @PostMapping("/delete")
    public IMOOCJSONResult delete(
            @RequestParam String id) {

        if (StringUtils.isBlank(id) ) {
            return IMOOCJSONResult.errorMsg("id不能为空!");
        }

        int num = mallProductService.deleteMallProduct(id);
        if (num > 0){
            return IMOOCJSONResult.ok();
        }else{
            return IMOOCJSONResult.errorMsg("删除数据失败!");
        }

    }
}
