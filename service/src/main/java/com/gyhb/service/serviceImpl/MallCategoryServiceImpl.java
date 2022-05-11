package com.gyhb.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.gyhb.entity.Appletmallcategory;
import com.gyhb.mapper.AppletmallcategoryMapper;
import com.gyhb.service.MallCategoryService;
import com.gyhb.service.WebSocket;
import com.gyhb.utils.utils.IMOOCJSONResult;
import org.apache.commons.lang3.StringUtils;
import org.n3r.idworker.Sid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class MallCategoryServiceImpl implements MallCategoryService {

    private final AppletmallcategoryMapper appletmallcategoryMapper;

    private final Sid sid;

    private final WebSocket webSocket;

    public MallCategoryServiceImpl(AppletmallcategoryMapper appletmallcategoryMapper, Sid sid, WebSocket webSocket) {
        this.appletmallcategoryMapper = appletmallcategoryMapper;
        this.sid = sid;
        this.webSocket = webSocket;
    }

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
            webSockMall();
            return IMOOCJSONResult.ok();
        }else {
            return IMOOCJSONResult.errorMsg("保存数据失败!");
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public IMOOCJSONResult updateMallCategory(Appletmallcategory appletmallcategory) {
        String id = appletmallcategory.getId();
        if(StringUtils.isBlank(id)){
            IMOOCJSONResult.errorMsg("id不能为空!");
        }
        Appletmallcategory rel = appletmallcategoryMapper.selectByPrimaryKey(id);
        rel.setName(appletmallcategory.getName());
        rel.setSort(appletmallcategory.getSort());
        rel.setStatus(0);
        rel.setUpdatetime(new Date());
        rel.setClassificationlevel(appletmallcategory.getClassificationlevel());
        rel.setIsdeleted(0);

        int i = appletmallcategoryMapper.insert(rel);
        if (i>0){
            webSockMall();
            return IMOOCJSONResult.ok();
        }else {
            return IMOOCJSONResult.errorMsg("修改数据失败!");
        }
    }

    @Override
    public List<Appletmallcategory> queryMallCategory() {
            List<Appletmallcategory> res ;
            res = appletmallcategoryMapper.selectAll();
        return res;
    }

    @Override
    public IMOOCJSONResult delMallCategory(List<String> lst) {
        int num = lst.size();
        if(num >= 1){
            for (String i: lst) {
                appletmallcategoryMapper.deleteByPrimaryKey(i);
            }
            webSockMall();
            return IMOOCJSONResult.ok(String.format("成功删除%d条数据!",num));
        }else{
           return IMOOCJSONResult.errorMsg("id不能为空！");
        }
    }

    private void webSockMall(){
        List<Appletmallcategory> re = appletmallcategoryMapper.selectAll();
        String resWeb = JSON.toJSONString(re);
        webSocket.sendMessage(resWeb);
    }

}
