package com.gyhb.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.gyhb.entity.Appletmallcategory;
import com.gyhb.entity.Appletmallproduct;
import com.gyhb.mapper.AppletmallcategoryMapper;
import com.gyhb.mapper.AppletmallproductMapper;
import com.gyhb.service.MallCategoryService;
import com.gyhb.service.MallProductService;
import com.gyhb.service.WebSocket;
import com.gyhb.service.mallProductTcp;
import com.gyhb.utils.utils.IMOOCJSONResult;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MallProductServiceImpl implements MallProductService {

    @Autowired
    private AppletmallproductMapper appletmallproductMapper;

    @Autowired
    private Sid sid;

    @Autowired
    private mallProductTcp webSocket;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public IMOOCJSONResult addMallProduct(Appletmallproduct appletmallproduct) {
        Appletmallproduct rel = new Appletmallproduct();
        //生产id
        String Id = sid.nextShort();
        rel.setId(Id);
        rel.setProductname(appletmallproduct.getProductname());
        rel.setProductnum(appletmallproduct.getProductnum());  //商品编号
        rel.setCategoryid(appletmallproduct.getCategoryid());  //商品类别id
        rel.setTitle(appletmallproduct.getTitle());
        rel.setDetail(appletmallproduct.getDetail());          //商品详情
        rel.setProductexplain(appletmallproduct.getProductexplain()); //商品本身说明/备注
        rel.setCoverimg(appletmallproduct.getCoverimg());      //封面图
        rel.setRecommendreason(appletmallproduct.getRecommendreason()); //推荐理由
        rel.setProductattribute(appletmallproduct.getProductattribute()); //商品属性/规格
        rel.setIshot(appletmallproduct.getIshot());            //热销商品
        rel.setProductstock(appletmallproduct.getProductstock()); //库存
        rel.setShelftime(appletmallproduct.getShelftime());    //上架时间
        rel.setOffshelftime(appletmallproduct.getOffshelftime()); //下架时间
        rel.setSaledeadline(appletmallproduct.getSaledeadline());  //出售截至时间
        rel.setAmount(appletmallproduct.getAmount());              //商品新价格
        rel.setOldamount(appletmallproduct.getOldamount());        //商品老价格
        rel.setPayamount(appletmallproduct.getPayamount());        //实际支付价格
        rel.setCouponid(appletmallproduct.getCouponid());          //优惠券id
        rel.setShopid(appletmallproduct.getShopid());              //商家id 京东，淘宝id
        rel.setCommissionrate(appletmallproduct.getCommissionrate()); //佣金比例
        rel.setAttachments(appletmallproduct.getAttachments());    //附件
        rel.setCourseid(appletmallproduct.getCourseid());          //负责人
        rel.setProgramme(appletmallproduct.getProgramme());        //复制，粘贴内容
        rel.setCourseid(appletmallproduct.getCourseid());          //教程模板ID
        rel.setCreattime(new Date());
        rel.setUpdatetime(new Date());
        rel.setStatus("0");
        rel.setIsdeleted("0");

        int i = appletmallproductMapper.insert(rel);
        if (i>0){
            List<Appletmallproduct> re = appletmallproductMapper.selectAll();
            String respo = JSON.toJSONString(re);
            webSocket.sendMessage(respo);
            return IMOOCJSONResult.ok();
        }else {
            return IMOOCJSONResult.errorMsg("保存数据失败!");
        }
    }

    @Override
    public List<Appletmallproduct> queryMallProduct() {
        List<Appletmallproduct> lst = appletmallproductMapper.selectAll();
        return lst;
    }

    @Override
    public Appletmallproduct queryDetails(String id) {
        Appletmallproduct lst = new Appletmallproduct();
        lst = appletmallproductMapper.selectByPrimaryKey(id);
        return lst;
    }


}
