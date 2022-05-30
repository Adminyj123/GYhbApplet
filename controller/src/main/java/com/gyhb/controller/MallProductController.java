package com.gyhb.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gyhb.entity.Appletmallproduct;
import com.gyhb.service.MallProductService;
import com.gyhb.utils.utils.IMOOCJSONResult;
import com.gyhb.utils.utils.PagedGridResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Admin-Yj
 */
@Api(value = "商品", tags = {"商品相关接口"})
@RestController
@RequestMapping("mallProduct")
public class MallProductController {

    public final MallProductService mallProductService;

    public static final Integer COMMON_PAGE_SIZE = 20;

    public MallProductController(MallProductService mallProductService) {
        this.mallProductService = mallProductService;
    }

    final static Logger logger = LoggerFactory.getLogger(MallProductController.class);

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

    @ApiOperation(value = "查询所有商品分页信息", notes = "查询所有商品分页信息", httpMethod = "GET")
    @GetMapping("/allListPage")
    public IMOOCJSONResult queryPageAll(
            @ApiParam(name = "ProductName",value = "商品名称", required = false)
            @RequestParam String ProductName,
            @ApiParam(name = "CategoryId", value = "商品类别", required = false)
            @RequestParam String CategoryId,
            @ApiParam(name = "status", value = "商品状态", required = false)
            @RequestParam String status,
            @ApiParam(name = "offDate", value = "下架时间（时）", required = false)
            @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
            @RequestParam String offDate,
            @ApiParam(name = "page", value = "查询下一页的第几页", required = false)
            @RequestParam Integer page,
            @ApiParam(name = "pageSize", value = "分页的每一页显示的条数", required = false)
            @RequestParam Integer pageSize) {

        if (page == null) {
            page = 1;
        }

        if (pageSize == null) {
            pageSize = COMMON_PAGE_SIZE;
        }

        String offDateStr = "";
        if(StringUtils.isNotBlank(offDate)){
            String rq = offDate.substring(0,10);
            String xs = offDate.substring(11,13);
            offDateStr =rq+' '+xs;
            logger.info(offDateStr);
        }

        PagedGridResult grid = mallProductService.queryPagedMall(ProductName, CategoryId, status,offDateStr, page, pageSize);

        return IMOOCJSONResult.ok(grid);
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

        int status = 200;
        IMOOCJSONResult checkRes = checkAppletMall(appletmallproduct);
        if (checkRes.getStatus() != status) {
            return checkRes;
        }

        return mallProductService.updateMallProduct(appletmallproduct);
    }

    private IMOOCJSONResult checkAppletMall(Appletmallproduct p){
        String name = p.getProductname();
        if (StringUtils.isBlank(name)) {
            return IMOOCJSONResult.errorMsg("商品名称不能为空!");
        }

        String zero = "0";
        String amount = p.getAmount().toString();
        if(amount == null || zero.equals(amount)|| "".equals(amount)){
            return IMOOCJSONResult.errorMsg("商品新价格不能为空!");
        }

        String oldAmount = p.getOldamount().toString();
        if(oldAmount == null|| zero.equals(oldAmount)|| "".equals(oldAmount)){
            return IMOOCJSONResult.errorMsg("商品老价格不能为空!");
        }

        String payAmount = p.getPayamount().toString();
        if(payAmount == null || zero.equals(payAmount)|| "".equals(payAmount)){
            return IMOOCJSONResult.errorMsg("商品实际支付价格不能为空!");
        }

        String coverImg = p.getCoverimg();
        if (StringUtils.isBlank(coverImg)){
            return IMOOCJSONResult.errorMsg("封面图不能为空!");
        }

        return IMOOCJSONResult.ok();
    }

    @ApiOperation(value="删除商品",notes = "删除商品（批量）",httpMethod = "POST")
    @PostMapping("/delete")
    public IMOOCJSONResult delMallCategory(@RequestParam(value="idList") List<String> idList){
        return mallProductService.deleteMallProduct(idList);
    }



}
