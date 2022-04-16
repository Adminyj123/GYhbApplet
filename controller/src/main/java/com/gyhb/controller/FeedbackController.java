package com.gyhb.controller;

import com.gyhb.entity.Appletfeedback;
import com.gyhb.service.AppletFeedbackService;
import com.gyhb.utils.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value = "用户反馈", tags = {"用户反馈的相关接口"})
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private AppletFeedbackService feedbackService;

    @ApiOperation(value="新增反馈信息",notes = "新增反馈信息",httpMethod = "POST")
    @PostMapping("/creatFeedback")
    public IMOOCJSONResult createFeedback(@RequestBody Appletfeedback feedback){
        IMOOCJSONResult res= feedbackService.create(feedback);

        return res;
    }
}
