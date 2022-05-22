package com.gyhb.service;

import com.gyhb.entity.Appletfeedback;
import com.gyhb.entity.Appletmallproduct;
import com.gyhb.utils.utils.IMOOCJSONResult;
import com.gyhb.utils.utils.PagedGridResult;

import java.util.List;

public interface AppletFeedbackService {

    /**
     * 新增
     *
     * @param appletfeedback
     * @return IMOOCJSONResult
     */
     IMOOCJSONResult create(Appletfeedback appletfeedback);

    /**
     * 查询永久反馈分页
     *
     * @param type   类型
     * @param DateStr   新增日期
     * @param status  状态
     * @param page 默认 1
     * @param pageSize  默认20
     * @return PagedGridResult
     */
    PagedGridResult queryPaged(String type,  String status, String DateStr, Integer page, Integer pageSize);


    /**
     * 查询反馈详情
     *
     * @param id
     * @return Appletfeedback
     */
    Appletfeedback queryDetails(String id);

    /**
     * 修改反馈详情
     *
     * @param appletfeedback
     * @return IMOOCJSONResult
     */
    IMOOCJSONResult updateFeedback(Appletfeedback appletfeedback);


    /**
     * 批量删除商品详情
     *
     * @param lst
     * @return IMOOCJSONResult
     */
    IMOOCJSONResult deleteFeedback(List<String> lst);
}
