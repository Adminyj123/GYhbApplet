package com.gyhb.controller;

import com.gyhb.entity.AppletAgreement;
import com.gyhb.service.AppletAgreementService;
import com.gyhb.utils.utils.IMOOCJSONResult;
import com.gyhb.utils.utils.JsonUtils;
import com.gyhb.utils.utils.RedisOperator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @author Admin-Yj
 */
@Api(value = "用户协议", tags = {"用户协议的相关接口"})
@RestController
@RequestMapping("Agreement")
public class AgreementController {

    final static Logger logger = LoggerFactory.getLogger(AgreementController.class);
    private final AppletAgreementService agreementService;

    private final RedisOperator redisAgreement;

    /**
     * REDIS 中 Agreement  协议
     */
    private static final String AGREEMENT_REDIS = "Agreement";

    public AgreementController(AppletAgreementService agreementService, RedisOperator redisAgreement) {
        this.agreementService = agreementService;
        this.redisAgreement = redisAgreement;
    }

    @ApiOperation(value = "获取用户协议", notes = "获取用户协议", httpMethod = "GET")
    @GetMapping("/getAgreement")
    public IMOOCJSONResult getUserAgreement(@RequestParam String id) {
        String rul = redisAgreement.get(AGREEMENT_REDIS+":"+id);

        AppletAgreement agreement;
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

        return agreementService.create(appAgreement);
    }

    @ApiOperation(value = "修改用户协议", notes = "修改用户协议", httpMethod = "POST")
    @PostMapping("/updateAgreement")
    public IMOOCJSONResult updateAgreement(@RequestBody AppletAgreement agreement) {
        String id = agreement.getId();
        if (StringUtils.isBlank(id)) {
            return IMOOCJSONResult.errorMsg("Id不能为空!");
        }else{
            String mainTitle = agreement.getMaintitle();
            if (StringUtils.isBlank(mainTitle)){
                return IMOOCJSONResult.errorMsg("主标题不能为空!");
            }else{



                String rul = redisAgreement.get(AGREEMENT_REDIS+":"+id);

                AppletAgreement rel ;
                //判断相关的redis 是否不为空
                if(StringUtils.isNotBlank(rul)){
                    rel = JsonUtils.jsonToPojo(rul,AppletAgreement.class);
                }else {  // redis中没有
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
                    redisAgreement.del(AGREEMENT_REDIS+":"+id);
                    redisAgreement.set(AGREEMENT_REDIS+":"+id,JsonUtils.objectToJson(rel));
                    return IMOOCJSONResult.ok(res);
                }else{
                    return IMOOCJSONResult.errorMsg("保存数据失败!");
                }

            }
        }
    }

    @ApiOperation(value = "删除用户协议", notes = "删除用户协议", httpMethod = "GET")
    @GetMapping("/delAgreement")
    public IMOOCJSONResult delAgreement(@RequestParam String id) {
        if (StringUtils.isBlank(id)) {
            return IMOOCJSONResult.errorMsg("id不能为空!");
        }
        return agreementService.deleteAgreement(id);
    }

}
