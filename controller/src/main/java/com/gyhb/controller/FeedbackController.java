package com.gyhb.controller;

import com.gyhb.entity.Appletfeedback;
import com.gyhb.service.AppletFeedbackService;
import com.gyhb.utils.utils.IMOOCJSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "用户反馈", tags = {"用户反馈的相关接口"})
@RequestMapping("/feedback")
public class FeedbackController {

    private final AppletFeedbackService feedbackService;

    public FeedbackController(AppletFeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @ApiOperation(value="新增反馈信息",notes = "新增反馈信息",httpMethod = "POST")
    @PostMapping("/creatFeedback")
    public IMOOCJSONResult createFeedback(@RequestBody Appletfeedback feedback){
        return  feedbackService.create(feedback);
    }


}
