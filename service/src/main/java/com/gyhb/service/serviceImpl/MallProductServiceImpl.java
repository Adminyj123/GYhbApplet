package com.gyhb.service.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gyhb.entity.Appletmallproduct;
import com.gyhb.mapper.AppletmallproductMapper;
import com.gyhb.service.MallProductService;
import com.gyhb.service.WebSocket;
import com.gyhb.utils.utils.IMOOCJSONResult;
import com.gyhb.utils.utils.PagedGridResult;
import org.n3r.idworker.Sid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MallProductServiceImpl implements MallProductService {

    @Autowired
    private AppletmallproductMapper appletmallproductMapper;

    final static Logger logger = LoggerFactory.getLogger(MallProductServiceImpl.class);

    @Autowired
    private Sid sid;

    @Autowired
    private WebSocket webSocket;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public IMOOCJSONResult addMallProduct(Appletmallproduct appletmallproduct) {
        Appletmallproduct rel = new Appletmallproduct();

        rel = fz(appletmallproduct,"0");
        //生产id
        String Id = sid.nextShort();
        rel.setId(Id);
        rel.setCreattime(new Date());

        try{
            int i = appletmallproductMapper.insert(rel);
            if (i>0){
                webSocket.sendMessage(JSONObject.toJSONString(rel));
                return IMOOCJSONResult.ok("操作成功！");
            }else {
                logger.error("新增商品数据时，保存数据失败" + rel);
                return IMOOCJSONResult.errorMsg("保存数据失败!");
            }
        }catch (Exception e){
            logger.error("新增商品数据时，保存数据失败" + e);
            return IMOOCJSONResult.errorMsg("保存数据失败!");
        }


    }

    @Override
    public List<Appletmallproduct> queryMallProduct() {
        List<Appletmallproduct> lst = appletmallproductMapper.queryMallAll();
        return lst;
    }

    @Override
    public Appletmallproduct queryDetails(String id) {
        Appletmallproduct lst = new Appletmallproduct();
        lst = appletmallproductMapper.selectByPrimaryKey(id);
        return lst;
    }

    @Override
    public IMOOCJSONResult updateMallProduct(Appletmallproduct appletmallproduct) {
        Appletmallproduct rel = fz(appletmallproduct,"1");

        int i = appletmallproductMapper.updateByPrimaryKey(rel);
        if (i>0){
            webSocket.sendMessage(JSONObject.toJSONString(appletmallproduct));
            return IMOOCJSONResult.ok("操作成功!");
        }else {
            logger.error("修改商品数据时，保存数据失败" + rel);
            return IMOOCJSONResult.errorMsg("保存数据失败!");
        }
    }

    // flag 用来标识是新增或者修改  "0" : 新增    “1” : 修改
    private Appletmallproduct fz(Appletmallproduct appletmallproduct,String flag){
        Appletmallproduct rel = new Appletmallproduct();
        // "1" 表示修改
        if(flag.equals("1")){
            rel = appletmallproductMapper.selectByPrimaryKey(appletmallproduct.getId());
            rel.setIsdeleted(appletmallproduct.getIsdeleted());
            rel.setStatus(appletmallproduct.getStatus());
        }else{
            rel.setIsdeleted("0");
            rel.setStatus("0");
        }
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
        rel.setUpdatetime(new Date());
        return rel;
    }

    @Override
    public IMOOCJSONResult deleteMallProduct(List<String> lst) {
        int num = lst.size();
        if(num >= 1){
            for (String i: lst) {
                // 真删除   （实体 isDelect 字段使用@.. 注解后  现在也为逻辑删除，只改变数据库字段属性，不真删除）
                appletmallproductMapper.deleteByPrimaryKey(i);

                //假删除，只改数据的状态
//                Example example = new Example(Appletmallproduct.class);
//                Example.Criteria criteria = example.createCriteria();
//                criteria.andEqualTo("id",i);
//                Appletmallproduct product = new Appletmallproduct();
//                product.setIsdeleted("1");
//                appletmallproductMapper.updateByExampleSelective(product,example);

            }
            webSockMall();
            return IMOOCJSONResult.ok(String.format("成功删除%d条数据!",num));
        }else{
            return IMOOCJSONResult.errorMsg("id不能为空！");
        }
    }

    private void webSockMall(){
        List<Appletmallproduct> re = appletmallproductMapper.selectAll();
        String resWeb = JSON.toJSONString(re);
        webSocket.sendMessage(resWeb);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,rollbackFor = Exception.class)
    public PagedGridResult queryPagedMall(String ProductName, String CategoryId, String status,String offDateStr, Integer page, Integer pageSize) {

        Map<String, Object> map = new HashMap<>();
        map.put("ProductName", ProductName);
        map.put("CategoryId", CategoryId);
        map.put("status", status);
        map.put("offDate", offDateStr);

        /**
         * page: 第几页
         * pageSize: 每页显示条数
         */
        PageHelper.startPage(page, pageSize);

        List<Appletmallproduct> list = appletmallproductMapper.queryMallPage(map);

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


}
