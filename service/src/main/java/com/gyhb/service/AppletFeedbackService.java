package com.gyhb.service;

import com.gyhb.entity.Appletfeedback;
import com.gyhb.utils.utils.IMOOCJSONResult;
import com.gyhb.utils.utils.PagedGridResult;

import java.util.List;

/**
 * @author YangJie
 * @date 2022/5/30 11:38
*/
public interface AppletFeedbackService {

    /**
     * 新增
     *
     * @param appletfeedback
     * @return IMOOCJSONResult
     */
     IMOOCJSONResult create(Appletfeedback appletfeedback);

    /**
     *  查询永久反馈分页
     * @param type 类型
     * @param status 状态
     * @param dateStr 新增日期
     * @param page 默认 1
     * @param pageSize 默认20
     * @return PagedGridResult
     */
    PagedGridResult queryPaged(String type,  String status, String dateStr, Integer page, Integer pageSize);


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
