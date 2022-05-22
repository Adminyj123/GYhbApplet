package com.gyhb.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gyhb.entity.Appletfeedback;
import com.gyhb.entity.Appletmallproduct;
import com.gyhb.mapper.AppletfeedbackMapper;
import com.gyhb.service.AppletFeedbackService;
import com.gyhb.service.WebSocket;
import com.gyhb.utils.utils.IMOOCJSONResult;
import com.gyhb.utils.utils.PagedGridResult;
import org.n3r.idworker.Sid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Admin-Yj
 */
@Service
public class AppletFeedbackServiceImpl implements AppletFeedbackService {

    private final AppletfeedbackMapper feedbackMapper;

    private final Sid sid;

    private final WebSocket webSocket;

    final static Logger logger = LoggerFactory.getLogger(AppletFeedbackServiceImpl.class);

    public AppletFeedbackServiceImpl(AppletfeedbackMapper feedbackMapper, Sid sid, WebSocket webSocket) {
        this.feedbackMapper = feedbackMapper;
        this.sid = sid;
        this.webSocket = webSocket;
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    @Override
    public IMOOCJSONResult create(Appletfeedback appletfeedback) {

        Example example = new Example(Appletfeedback.class);
        Example.Criteria criteria= example.createCriteria();
        criteria.andEqualTo("Id",appletfeedback.getId());
        criteria.andEqualTo("UserId",appletfeedback.getUserId());

        List<Appletfeedback> lst = feedbackMapper.selectByExample(example);

        //当lst不等于空且长度大于0 时,说明 数据库中存在 同一个用户对同一个商品的反馈
        if(lst != null && lst.size()>0){
            return IMOOCJSONResult.ok("感谢您的反馈，客服正在核实!");
        }else{
            Appletfeedback rel = new Appletfeedback();
            //生产id
            String id = sid.nextShort();
            rel.setId(id);
            rel.setUserId(appletfeedback.getUserId());
            rel.setProductId(appletfeedback.getProductId());
            rel.setType(appletfeedback.getType());
            rel.setPhone(appletfeedback.getPhone());
            rel.setInfo(appletfeedback.getInfo());
            rel.setPicUrl(appletfeedback.getPicUrl());
            rel.setReplyContent(appletfeedback.getReplyContent());
            rel.setReplayUser(appletfeedback.getReplayUser());
            rel.setDevice(appletfeedback.getDevice());
            rel.setCorrectionUser(appletfeedback.getCorrectionUser());
            rel.setAddress(appletfeedback.getAddress());
            rel.setStatus("0");
            rel.setIsDeleted("0");
            rel.setCreatTime(new Date());
            rel.setUpdateTime(new Date());

            try{
                int i = feedbackMapper.insert(rel);
                if (i>0){
                    webSocket.sendMessage("有新的用户反馈，注意查看!");
                    return IMOOCJSONResult.ok("新增反馈成功!");
                }else {
                    return IMOOCJSONResult.errorMsg("保存数据失败!");
                }
            }catch(Exception e){
                logger.error("新增反馈是保存数据失败 {}",e);
                return IMOOCJSONResult.errorMsg("保存数据失败!");
            }
        }
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    public PagedGridResult queryPaged(String type, String status, String DateStr, Integer page, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("type", type);
        map.put("status", status);
        map.put("creatTime", DateStr);

        /**
         * page: 第几页
         * pageSize: 每页显示条数
         */
        PageHelper.startPage(page, pageSize);

        List<Appletfeedback> list = feedbackMapper.queryPage(map);

        return setterPagedGrid(list, page);
    }

    private PagedGridResult setterPagedGrid(List<?> list, Integer page) {
        PageInfo<?> pageList = new PageInfo<>(list);
        PagedGridResult grid = new PagedGridResult();
        grid.setPage(page);
        grid.setRows(list);
        grid.setTotal(pageList.getPages());
        grid.setRecords(pageList.getTotal());
        return grid;
    }


    @Override
    public Appletfeedback queryDetails(String id) {
        Appletfeedback lst ;
        lst = feedbackMapper.selectByPrimaryKey(id);
        return lst;
    }

    @Override
    public IMOOCJSONResult updateFeedback(Appletfeedback appletfeedback) {
        Appletfeedback rel = feedbackMapper.selectByPrimaryKey(appletfeedback.getId());
        rel.setUserId(appletfeedback.getUserId());
        rel.setProductId(appletfeedback.getProductId());
        rel.setType(appletfeedback.getType());
        rel.setPhone(appletfeedback.getPhone());
        rel.setInfo(appletfeedback.getInfo());
        rel.setPicUrl(appletfeedback.getPicUrl());
        rel.setReplyContent(appletfeedback.getReplyContent());
        rel.setReplayUser(appletfeedback.getReplayUser());
        rel.setDevice(appletfeedback.getDevice());
        rel.setCorrectionUser(appletfeedback.getCorrectionUser());
        rel.setAddress(appletfeedback.getAddress());
        rel.setStatus(appletfeedback.getStatus());
        rel.setUpdateTime(new Date());

        try{
            int i = feedbackMapper.updateByPrimaryKey(rel);
            if (i>0){
                webSocket.sendMessage("用户反馈修改成功，注意查看!");
                return IMOOCJSONResult.ok("修改反馈成功!");
            }else {
                return IMOOCJSONResult.errorMsg("保存数据失败!");
            }
        }catch(Exception e){
            logger.error("修改反馈时保存数据失败 {}",e);
            return IMOOCJSONResult.errorMsg("保存数据失败!");
        }
    }

    @Override
    public IMOOCJSONResult deleteFeedback(List<String> lst) {
        int num = lst.size();
        if(num >= 1){
            for (String i: lst) {
                // 真删除   （实体 isDelect 字段使用@LogicDelete 注解后  现在也为逻辑删除，只改变数据库字段属性，不真删除）
                feedbackMapper.deleteByPrimaryKey(i);
            }
            webSockMall();
            return IMOOCJSONResult.ok(String.format("成功删除%d条数据!",num));
        }else{
            return IMOOCJSONResult.errorMsg("id不能为空！");
        }
    }

    private void webSockMall(){
        List<Appletfeedback> re = feedbackMapper.selectAll();
        String resWeb = JSON.toJSONString(re);
        webSocket.sendMessage(resWeb);
    }


}
