package com.gyhb.controller;

import com.gyhb.entity.AppletAgreement;
import com.gyhb.entity.bo.Carousel;
import com.gyhb.service.AppletAgreementService;
import com.gyhb.utils.utils.IMOOCJSONResult;
import com.gyhb.utils.utils.JsonUtils;
import com.gyhb.utils.utils.RedisOperator;
import com.gyhb.utils.utils.YesOrNo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Api(value = "用户协议", tags = {"用户协议的相关接口"})
@RestController
@RequestMapping("Agreement")
public class AgreementController {

    @Autowired
    private AppletAgreementService agreementService;

    @Autowired
    private RedisOperator redisAgreemetn;

    private static final String AGREEMENT_REDIS = "Agreement";//REDIS 中 Agreement  协议

    @ApiOperation(value = "获取用户协议", notes = "获取用户协议", httpMethod = "GET")
    @GetMapping("/getAgreement")
    public IMOOCJSONResult getUserAgreement(@RequestParam String id) {
        String rul = redisAgreemetn.get(AGREEMENT_REDIS+":"+id);

        AppletAgreement agreement = new AppletAgreement();
        if(StringUtils.isNotBlank(rul)){
            agreement = JsonUtils.jsonToPojo(rul,AppletAgreement.class);
        }else {
            agreement = agreementService.queryAgreement(id);
            if (agreement == null){
                return IMOOCJSONResult.errorMsg("用户id不存在!");
            }

        }
        return IMOOCJSONResult.ok(agreement);
    }

    @ApiOperation(value = "新增用户协议", notes = "新增用户协议", httpMethod = "POST")
    @PostMapping("/createAgreement")
    public IMOOCJSONResult addAgreement(@RequestBody AppletAgreement appAgreement) {
        if (StringUtils.isBlank(appAgreement.getMaintitle())) {
            return IMOOCJSONResult.errorMsg("主标题不能为空!");
        }

        IMOOCJSONResult res= agreementService.create(appAgreement);
        return res;
    }

    @ApiOperation(value = "修改用户协议", notes = "修改用户协议", httpMethod = "POST")
    @PostMapping("/updateAgreement")
    public IMOOCJSONResult updateAgreement(@RequestBody AppletAgreement agreement) {
        String id = agreement.getId();
        if (StringUtils.isBlank(id)) {
            return IMOOCJSONResult.errorMsg("Id不能为空!");
        }else{
            String rul = redisAgreemetn.get(AGREEMENT_REDIS+":"+id);

            AppletAgreement rel = new AppletAgreement();
            if(StringUtils.isNotBlank(rul)){
                rel = JsonUtils.jsonToPojo(rul,AppletAgreement.class);
            }else {
                rel = agreementService.queryAgreement(id);
            }

            rel.setMaintitle(agreement.getMaintitle());
            rel.setBz(agreement.getBz());
            rel.setCategory(agreement.getCategory());
            rel.setContent(agreement.getContent());
            rel.setCover(agreement.getCover());
            rel.setEditor(agreement.getEditor());
            rel.setEntrytime(agreement.getEntrytime());
            rel.setOutline(agreement.getOutline());
            rel.setSort(agreement.getSort());
            rel.setSubheading(agreement.getSubheading());
            rel.setUpdatetime(new Date());

            int res= agreementService.update(rel);
            if (res>0){
                redisAgreemetn.del(AGREEMENT_REDIS+":"+id);
                redisAgreemetn.set(AGREEMENT_REDIS+":"+id,JsonUtils.objectToJson(rel));
                return IMOOCJSONResult.ok(res);
            }else{
                return IMOOCJSONResult.errorMsg("保存数据失败!");
            }
        }
    }

    @ApiOperation(value = "删除用户协议", notes = "删除用户协议", httpMethod = "GET")
    @GetMapping("/delAgreement")
    public IMOOCJSONResult delAgreement(@RequestParam String id) {
        if (StringUtils.isBlank(id)) {
            return IMOOCJSONResult.errorMsg("id不能为空!");
        }

        IMOOCJSONResult res= agreementService.deletAgreement(id);
        return res;
    }

}
