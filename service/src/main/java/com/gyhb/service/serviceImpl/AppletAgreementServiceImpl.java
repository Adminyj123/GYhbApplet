package com.gyhb.service.serviceImpl;

import com.gyhb.entity.AppletAgreement;
import com.gyhb.mapper.AppletAgreementMapper;
import com.gyhb.service.AppletAgreementService;
import com.gyhb.utils.utils.IMOOCJSONResult;
import com.gyhb.utils.utils.JsonUtils;
import com.gyhb.utils.utils.RedisOperator;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class AppletAgreementServiceImpl implements AppletAgreementService {

    @Autowired
    private AppletAgreementMapper agreementMapper;

    @Autowired
    private Sid sid;

    private static final String AGREEMENT_REDIS = "Agreement";//REDIS 中 Agreement  协议

    @Override
    public AppletAgreement queryAgreement(String id) {
        AppletAgreement agreement = new AppletAgreement();
        agreement = agreementMapper.selectByPrimaryKey(id);
        return agreement;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public IMOOCJSONResult create(AppletAgreement agreement) {
        AppletAgreement rel = new AppletAgreement();
        //生产id
        String Id = sid.nextShort();
        rel.setId(Id);
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
        rel.setCreatetime(new Date());

        int i = agreementMapper.insert(agreement);
        if (i>0){
            RedisOperator redisOperator=new RedisOperator();
            redisOperator.set(AGREEMENT_REDIS+":"+Id, JsonUtils.objectToJson(rel));
            return IMOOCJSONResult.ok(rel);
        }else {
            return IMOOCJSONResult.errorMsg("保存数据失败!");
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public int update(AppletAgreement agreement) {
        return agreementMapper.updateByPrimaryKey(agreement);
    }

    @Override
    public IMOOCJSONResult deletAgreement(String id) {
        int num = agreementMapper.deleteByPrimaryKey(id);
        if(num>0){
            RedisOperator redisOperator = new RedisOperator();
            redisOperator.del(AGREEMENT_REDIS+":"+id);
            return IMOOCJSONResult.ok("删除数据成功!");
        }else{
            return IMOOCJSONResult.errorMsg("删除数据失败!");
        }

    }
}
