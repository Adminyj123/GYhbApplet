package com.gyhb.service.serviceImpl;

import com.gyhb.entity.Appletfeedback;
import com.gyhb.mapper.AppletfeedbackMapper;
import com.gyhb.service.AppletFeedbackService;
import com.gyhb.service.WebSocket;
import com.gyhb.utils.utils.IMOOCJSONResult;
import org.n3r.idworker.Sid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class AppletFeedbackServiceImpl implements AppletFeedbackService {

    private final AppletfeedbackMapper feedbackMapper;

    private final Sid sid;

    private final WebSocket webSocket;

    public AppletFeedbackServiceImpl(AppletfeedbackMapper feedbackMapper, Sid sid, WebSocket webSocket) {
        this.feedbackMapper = feedbackMapper;
        this.sid = sid;
        this.webSocket = webSocket;
    }

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
