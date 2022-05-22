package com.gyhb.entity;

import tk.mybatis.mapper.annotation.LogicDelete;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "AppletMallProduct")
public class Appletmallproduct {
    /**
     * Id 商品id
     */
    @Id
    @Column(name = "Id")
    private String id;

    /**
     * ProductName 商品名称
     */
    @Column(name = "ProductName")
    private String productname;

    /**
     * ProductNum 商品编号
     */
    @Column(name = "ProductNum")
    private String productnum;

    /**
     * CategoryId 商品类别
     */
    @Column(name = "CategoryId")
    private String categoryid;

    /**
     * Title 标题
     */
    @Column(name = "Title")
    private String title;

    /**
     * Detail 商品详情
     */
    @Column(name = "Detail")
    private String detail;

    /**
     * ProductExplain 商品本身说明/备注
     */
    @Column(name = "ProductExplain")
    private String productexplain;

    /**
     * CoverImg 封面图
     */
    @Column(name = "CoverImg")
    private String coverimg;

    /**
     * RecommendReason 推荐理由
     */
    @Column(name = "RecommendReason")
    private String recommendreason;

    /**
     * ProductAttribute 商品属性/规格
     */
    @Column(name = "ProductAttribute")
    private String productattribute;

    /**
     * IsHot 热销商品
     */
    @Column(name = "IsHot")
    private String ishot;

    /**
     * ProductStock 库存
     */
    @Column(name = "ProductStock")
    private String productstock;

    /**
     * ShelfTime 上架时间
     */
    @Column(name = "ShelfTime")
    private Date shelftime;

    /**
     * OffShelfTime 下架时间
     */
    @Column(name = "OffShelfTime")
    private Date offshelftime;

    /**
     * SaleDeadline 出售截至时间
     */
    @Column(name = "SaleDeadline")
    private Date saledeadline;

    /**
     * Amount 商品新价格
     */
    @Column(name = "Amount")
    private BigDecimal amount;

    /**
     * OldAmount 商品老价格
     */
    @Column(name = "OldAmount")
    private BigDecimal oldamount;

    /**
     * PayAmount 实际支付价格
     */
    @Column(name = "PayAmount")
    private BigDecimal payamount;

    /**
     * CouponId 优惠券Id
     */
    @Column(name = "CouponId")
    private String couponid;

    /**
     * ShopId 店铺Id（淘宝/京东/pdd）
     */
    @Column(name = "ShopId")
    private String shopid;

    /**
     * CommissionRate 佣金比例
     */
    @Column(name = "CommissionRate")
    private String commissionrate;

    /**
     * Attachments 附件
     */
    @Column(name = "Attachments")
    private String attachments;

    /**
     * Custodian 负责人
     */
    @Column(name = "Custodian")
    private String custodian;

    /**
     * Programme 方案复制/粘贴内容
     */
    @Column(name = "Programme")
    private String programme;

    /**
     * CourseId 教程模板ID
     */
    @Column(name = "CourseId")
    private String courseid;

    /**
     * CreatTime 创建时间
     */
    @Column(name = "CreatTime")
    private Date creattime;

    /**
     * UpdateTime 更新时间
     */
    @Column(name = "UpdateTime")
    private Date updatetime;

    /**
     * Status 状态标志位（0：正常，1：不正常）
     */
    @Column(name = "Status")
    private String status;

    /**
     * IsDeleted 删除标志位（0：正常，1：删除）
     */
    @Column(name = "IsDeleted")
    @LogicDelete
    private String isdeleted;

    /**
     * Addinfo0 预留字段
     */
    @Column(name = "Addinfo0")
    private String addinfo0;

    /**
     * Addinfo1
     */
    @Column(name = "Addinfo1")
    private String addinfo1;

    /**
     * Addinfo2
     */
    @Column(name = "Addinfo2")
    private String addinfo2;

    /**
     * Addinfo3
     */
    @Column(name = "Addinfo3")
    private String addinfo3;

    /**
     * Addinfo4
     */
    @Column(name = "Addinfo4")
    private String addinfo4;

    /**
     * 获取Id 商品id
     *
     * @return Id - Id 商品id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置Id 商品id
     *
     * @param id Id 商品id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取ProductName 商品名称
     *
     * @return ProductName - ProductName 商品名称
     */
    public String getProductname() {
        return productname;
    }

    /**
     * 设置ProductName 商品名称
     *
     * @param productname ProductName 商品名称
     */
    public void setProductname(String productname) {
        this.productname = productname;
    }

    /**
     * 获取ProductNum 商品编号
     *
     * @return ProductNum - ProductNum 商品编号
     */
    public String getProductnum() {
        return productnum;
    }

    /**
     * 设置ProductNum 商品编号
     *
     * @param productnum ProductNum 商品编号
     */
    public void setProductnum(String productnum) {
        this.productnum = productnum;
    }

    /**
     * 获取CategoryId 商品类别
     *
     * @return CategoryId - CategoryId 商品类别
     */
    public String getCategoryid() {
        return categoryid;
    }

    /**
     * 设置CategoryId 商品类别
     *
     * @param categoryid CategoryId 商品类别
     */
    public void setCategoryid(String categoryid) {
        this.categoryid = categoryid;
    }

    /**
     * 获取Title 标题
     *
     * @return Title - Title 标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置Title 标题
     *
     * @param title Title 标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取Detail 商品详情
     *
     * @return Detail - Detail 商品详情
     */
    public String getDetail() {
        return detail;
    }

    /**
     * 设置Detail 商品详情
     *
     * @param detail Detail 商品详情
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * 获取ProductExplain 商品本身说明/备注
     *
     * @return ProductExplain - ProductExplain 商品本身说明/备注
     */
    public String getProductexplain() {
        return productexplain;
    }

    /**
     * 设置ProductExplain 商品本身说明/备注
     *
     * @param productexplain ProductExplain 商品本身说明/备注
     */
    public void setProductexplain(String productexplain) {
        this.productexplain = productexplain;
    }

    /**
     * 获取CoverImg 封面图
     *
     * @return CoverImg - CoverImg 封面图
     */
    public String getCoverimg() {
        return coverimg;
    }

    /**
     * 设置CoverImg 封面图
     *
     * @param coverimg CoverImg 封面图
     */
    public void setCoverimg(String coverimg) {
        this.coverimg = coverimg;
    }

    /**
     * 获取RecommendReason 推荐理由
     *
     * @return RecommendReason - RecommendReason 推荐理由
     */
    public String getRecommendreason() {
        return recommendreason;
    }

    /**
     * 设置RecommendReason 推荐理由
     *
     * @param recommendreason RecommendReason 推荐理由
     */
    public void setRecommendreason(String recommendreason) {
        this.recommendreason = recommendreason;
    }

    /**
     * 获取ProductAttribute 商品属性/规格
     *
     * @return ProductAttribute - ProductAttribute 商品属性/规格
     */
    public String getProductattribute() {
        return productattribute;
    }

    /**
     * 设置ProductAttribute 商品属性/规格
     *
     * @param productattribute ProductAttribute 商品属性/规格
     */
    public void setProductattribute(String productattribute) {
        this.productattribute = productattribute;
    }

    /**
     * 获取IsHot 热销商品
     *
     * @return IsHot - IsHot 热销商品
     */
    public String getIshot() {
        return ishot;
    }

    /**
     * 设置IsHot 热销商品
     *
     * @param ishot IsHot 热销商品
     */
    public void setIshot(String ishot) {
        this.ishot = ishot;
    }

    /**
     * 获取ProductStock 库存
     *
     * @return ProductStock - ProductStock 库存
     */
    public String getProductstock() {
        return productstock;
    }

    /**
     * 设置ProductStock 库存
     *
     * @param productstock ProductStock 库存
     */
    public void setProductstock(String productstock) {
        this.productstock = productstock;
    }

    /**
     * 获取ShelfTime 上架时间
     *
     * @return ShelfTime - ShelfTime 上架时间
     */
    public Date getShelftime() {
        return shelftime;
    }

    /**
     * 设置ShelfTime 上架时间
     *
     * @param shelftime ShelfTime 上架时间
     */
    public void setShelftime(Date shelftime) {
        this.shelftime = shelftime;
    }

    /**
     * 获取OffShelfTime 下架时间
     *
     * @return OffShelfTime - OffShelfTime 下架时间
     */
    public Date getOffshelftime() {
        return offshelftime;
    }

    /**
     * 设置OffShelfTime 下架时间
     *
     * @param offshelftime OffShelfTime 下架时间
     */
    public void setOffshelftime(Date offshelftime) {
        this.offshelftime = offshelftime;
    }

    /**
     * 获取SaleDeadline 出售截至时间
     *
     * @return SaleDeadline - SaleDeadline 出售截至时间
     */
    public Date getSaledeadline() {
        return saledeadline;
    }

    /**
     * 设置SaleDeadline 出售截至时间
     *
     * @param saledeadline SaleDeadline 出售截至时间
     */
    public void setSaledeadline(Date saledeadline) {
        this.saledeadline = saledeadline;
    }

    /**
     * 获取Amount 商品新价格
     *
     * @return Amount - Amount 商品新价格
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 设置Amount 商品新价格
     *
     * @param amount Amount 商品新价格
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 获取OldAmount 商品老价格
     *
     * @return OldAmount - OldAmount 商品老价格
     */
    public BigDecimal getOldamount() {
        return oldamount;
    }

    /**
     * 设置OldAmount 商品老价格
     *
     * @param oldamount OldAmount 商品老价格
     */
    public void setOldamount(BigDecimal oldamount) {
        this.oldamount = oldamount;
    }

    /**
     * 获取PayAmount 实际支付价格
     *
     * @return PayAmount - PayAmount 实际支付价格
     */
    public BigDecimal getPayamount() {
        return payamount;
    }

    /**
     * 设置PayAmount 实际支付价格
     *
     * @param payamount PayAmount 实际支付价格
     */
    public void setPayamount(BigDecimal payamount) {
        this.payamount = payamount;
    }

    /**
     * 获取CouponId 优惠券Id
     *
     * @return CouponId - CouponId 优惠券Id
     */
    public String getCouponid() {
        return couponid;
    }

    /**
     * 设置CouponId 优惠券Id
     *
     * @param couponid CouponId 优惠券Id
     */
    public void setCouponid(String couponid) {
        this.couponid = couponid;
    }

    /**
     * 获取ShopId 店铺Id（淘宝/京东/pdd）
     *
     * @return ShopId - ShopId 店铺Id（淘宝/京东/pdd）
     */
    public String getShopid() {
        return shopid;
    }

    /**
     * 设置ShopId 店铺Id（淘宝/京东/pdd）
     *
     * @param shopid ShopId 店铺Id（淘宝/京东/pdd）
     */
    public void setShopid(String shopid) {
        this.shopid = shopid;
    }

    /**
     * 获取CommissionRate 佣金比例
     *
     * @return CommissionRate - CommissionRate 佣金比例
     */
    public String getCommissionrate() {
        return commissionrate;
    }

    /**
     * 设置CommissionRate 佣金比例
     *
     * @param commissionrate CommissionRate 佣金比例
     */
    public void setCommissionrate(String commissionrate) {
        this.commissionrate = commissionrate;
    }

    /**
     * 获取Attachments 附件
     *
     * @return Attachments - Attachments 附件
     */
    public String getAttachments() {
        return attachments;
    }

    /**
     * 设置Attachments 附件
     *
     * @param attachments Attachments 附件
     */
    public void setAttachments(String attachments) {
        this.attachments = attachments;
    }

    /**
     * 获取Custodian 负责人
     *
     * @return Custodian - Custodian 负责人
     */
    public String getCustodian() {
        return custodian;
    }

    /**
     * 设置Custodian 负责人
     *
     * @param custodian Custodian 负责人
     */
    public void setCustodian(String custodian) {
        this.custodian = custodian;
    }

    /**
     * 获取Programme 方案复制/粘贴内容
     *
     * @return Programme - Programme 方案复制/粘贴内容
     */
    public String getProgramme() {
        return programme;
    }

    /**
     * 设置Programme 方案复制/粘贴内容
     *
     * @param programme Programme 方案复制/粘贴内容
     */
    public void setProgramme(String programme) {
        this.programme = programme;
    }

    /**
     * 获取CourseId 教程模板ID
     *
     * @return CourseId - CourseId 教程模板ID
     */
    public String getCourseid() {
        return courseid;
    }

    /**
     * 设置CourseId 教程模板ID
     *
     * @param courseid CourseId 教程模板ID
     */
    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    /**
     * 获取CreatTime 创建时间
     *
     * @return CreatTime - CreatTime 创建时间
     */
    public Date getCreattime() {
        return creattime;
    }

    /**
     * 设置CreatTime 创建时间
     *
     * @param creattime CreatTime 创建时间
     */
    public void setCreattime(Date creattime) {
        this.creattime = creattime;
    }

    /**
     * 获取UpdateTime 更新时间
     *
     * @return UpdateTime - UpdateTime 更新时间
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置UpdateTime 更新时间
     *
     * @param updatetime UpdateTime 更新时间
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 获取Status 状态标志位（0：正常，1：不正常）
     *
     * @return Status - Status 状态标志位（0：正常，1：不正常）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置Status 状态标志位（0：正常，1：不正常）
     *
     * @param status Status 状态标志位（0：正常，1：不正常）
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取IsDeleted 删除标志位（0：正常，1：删除）
     *
     * @return IsDeleted - IsDeleted 删除标志位（0：正常，1：删除）
     */
    public String getIsdeleted() {
        return isdeleted;
    }

    /**
     * 设置IsDeleted 删除标志位（0：正常，1：删除）
     *
     * @param isdeleted IsDeleted 删除标志位（0：正常，1：删除）
     */
    public void setIsdeleted(String isdeleted) {
        this.isdeleted = isdeleted;
    }

    /**
     * 获取Addinfo0 预留字段
     *
     * @return Addinfo0 - Addinfo0 预留字段
     */
    public String getAddinfo0() {
        return addinfo0;
    }

    /**
     * 设置Addinfo0 预留字段
     *
     * @param addinfo0 Addinfo0 预留字段
     */
    public void setAddinfo0(String addinfo0) {
        this.addinfo0 = addinfo0;
    }

    /**
     * 获取Addinfo1
     *
     * @return Addinfo1 - Addinfo1
     */
    public String getAddinfo1() {
        return addinfo1;
    }

    /**
     * 设置Addinfo1
     *
     * @param addinfo1 Addinfo1
     */
    public void setAddinfo1(String addinfo1) {
        this.addinfo1 = addinfo1;
    }

    /**
     * 获取Addinfo2
     *
     * @return Addinfo2 - Addinfo2
     */
    public String getAddinfo2() {
        return addinfo2;
    }

    /**
     * 设置Addinfo2
     *
     * @param addinfo2 Addinfo2
     */
    public void setAddinfo2(String addinfo2) {
        this.addinfo2 = addinfo2;
    }

    /**
     * 获取Addinfo3
     *
     * @return Addinfo3 - Addinfo3
     */
    public String getAddinfo3() {
        return addinfo3;
    }

    /**
     * 设置Addinfo3
     *
     * @param addinfo3 Addinfo3
     */
    public void setAddinfo3(String addinfo3) {
        this.addinfo3 = addinfo3;
    }

    /**
     * 获取Addinfo4
     *
     * @return Addinfo4 - Addinfo4
     */
    public String getAddinfo4() {
        return addinfo4;
    }

    /**
     * 设置Addinfo4
     *
     * @param addinfo4 Addinfo4
     */
    public void setAddinfo4(String addinfo4) {
        this.addinfo4 = addinfo4;
    }
}