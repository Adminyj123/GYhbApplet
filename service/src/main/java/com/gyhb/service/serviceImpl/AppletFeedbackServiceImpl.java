package com.gyhb.service.serviceImpl;

import com.gyhb.entity.AppletAgreement;
import com.gyhb.entity.Appletfeedback;
import com.gyhb.mapper.AppletfeedbackMapper;
import com.gyhb.service.AppletFeedbackService;
import com.gyhb.service.WebSocket;
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
public class AppletFeedbackServiceImpl implements AppletFeedbackService {

    @Autowired
    private AppletfeedbackMapper feedbackMapper;

    @Autowired
    private Sid sid;

    @Autowired
    private WebSocket webSocket;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public IMOOCJSONResult create(Appletfeedback appletfeedback) {
        Appletfeedback rel = new Appletfeedback();
        //生产id
        String Id = sid.nextShort();
        rel.setId(Id);
        rel.setUserid(appletfeedback.getUserid());
        rel.setType(appletfeedback.getType());
        rel.setPhone(appletfeedback.getPhone());
        rel.setInfo(appletfeedback.getInfo());
        rel.setPicurl(appletfeedback.getPicurl());
        rel.setValidflag("0");
        rel.setTime(appletfeedback.getTime());
        rel.setFlag("0");
        rel.setCreatedTime(new Date());

        int i = feedbackMapper.insert(rel);
        if (i>0){
            webSocket.sendMessage("有新的用户反馈，注意查看!");
            return IMOOCJSONResult.ok();
        }else {
            return IMOOCJSONResult.errorMsg("保存数据失败!");
        }
    }
}
