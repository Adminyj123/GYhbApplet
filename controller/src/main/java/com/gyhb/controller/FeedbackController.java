package com.gyhb.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gyhb.entity.AppletAgreement;
import com.gyhb.entity.Appletfeedback;
import com.gyhb.entity.Appletmallproduct;
import com.gyhb.service.AppletFeedbackService;
import com.gyhb.utils.utils.IMOOCJSONResult;
import com.gyhb.utils.utils.JsonUtils;
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
@RestController
@Api(value = "用户反馈", tags = {"用户反馈的相关接口"})
@RequestMapping("/feedback")
public class FeedbackController {

    final static Logger logger = LoggerFactory.getLogger(FeedbackController.class);
    private final AppletFeedbackService feedbackService;

    public static final Integer COMMON_PAGE_SIZE = 20;

    public FeedbackController(AppletFeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @ApiOperation(value="新增反馈信息",notes = "新增反馈信息",httpMethod = "POST")
    @PostMapping("/creatFeedback")
    public IMOOCJSONResult createFeedback(@RequestBody Appletfeedback feedback){
        return  feedbackService.create(feedback);
    }

    @ApiOperation(value = "查询用户反馈分页信息", notes = "查询用户反馈分页信息", httpMethod = "GET")
    @GetMapping("/allListPage")
    public IMOOCJSONResult queryPageAll(
            @ApiParam(name = "type", value = "意见类型", required = false)
            @RequestParam String type,
            @ApiParam(name = "status", value = "状态", required = false)
            @RequestParam String status,
            @ApiParam(name = "createDate", value = "创建时间（日）", required = false)
            @JsonFormat(pattern = "yyyy-MM-dd")
            @RequestParam String createDate,
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

        String dateStr = "";
        if(StringUtils.isNotBlank(createDate)){
            dateStr = createDate.substring(0,10);
        }else{
            dateStr = "";
        }

        PagedGridResult grid = feedbackService.queryPaged(type, status,dateStr, page, pageSize);

        return IMOOCJSONResult.ok(grid);
    }

    @ApiOperation(value="查询反馈详情",notes = "查询反馈详情",httpMethod = "GET")
    @GetMapping("/details")
    public IMOOCJSONResult queryDetails(@RequestParam String id){
        Appletfeedback lst = feedbackService.queryDetails(id);
        return IMOOCJSONResult.ok(lst) ;
    }

    @ApiOperation(value = "修改反馈信息", notes = "修改反馈信息", httpMethod = "POST")
    @PostMapping("/update")
    public IMOOCJSONResult update(@RequestBody Appletfeedback appletfeedback) {

        if (StringUtils.isBlank(appletfeedback.getId())) {
            return IMOOCJSONResult.errorMsg("Id不能为空");
        }

        return feedbackService.updateFeedback(appletfeedback);
    }

    @ApiOperation(value="删除反馈信息",notes = "删除反馈信息（批量）",httpMethod = "POST")
    @PostMapping("/delete")
    public IMOOCJSONResult delFeedback(@RequestParam(value="idList") List<String> idList){
        return feedbackService.deleteFeedback(idList);
    }


}
