package com.gyhb.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.gyhb.entity.Appletfeedback;
import com.gyhb.entity.Appletmallcategory;
import com.gyhb.mapper.AppletfeedbackMapper;
import com.gyhb.mapper.AppletmallcategoryMapper;
import com.gyhb.service.MallCategoryService;
import com.gyhb.service.WebSocket;
import com.gyhb.utils.utils.IMOOCJSONResult;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class MallCategoryServiceImpl implements MallCategoryService {

    @Autowired
    private AppletmallcategoryMapper appletmallcategoryMapper;

    @Autowired
    private Sid sid;

    @Autowired
    private WebSocket webSocket;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public IMOOCJSONResult addMallCategory(Appletmallcategory appletmallcategory) {
        Appletmallcategory rel = new Appletmallcategory();
        //生产id
        String Id = sid.nextShort();
        rel.setId(Id);
        rel.setName(appletmallcategory.getName());
        rel.setSort(appletmallcategory.getSort());
        rel.setStatus(0);
        rel.setCreatetime(new Date());
        rel.setUpdatetime(new Date());
        rel.setClassificationlevel(appletmallcategory.getClassificationlevel());
        rel.setIsdeleted(0);

        int i = appletmallcategoryMapper.insert(rel);
        if (i>0){
            List<Appletmallcategory> re = appletmallcategoryMapper.selectAll();
            String respo = JSON.toJSONString(re);
//            webSocket.sendMessage(rel.toString());
            webSocket.sendMessage(respo);
            return IMOOCJSONResult.ok();
        }else {
            return IMOOCJSONResult.errorMsg("保存数据失败!");
        }
    }
}
