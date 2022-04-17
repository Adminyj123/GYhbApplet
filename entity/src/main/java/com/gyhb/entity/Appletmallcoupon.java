package com.gyhb.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "AppletMallCoupon")
public class Appletmallcoupon {
    /**
     * Id 优惠券id
     */
    @Id
    @Column(name = "Id")
    private String id;

    /**
     * StartTime 开始时间
     */
    @Id
    @Column(name = "StartTime")
    private Date starttime;

    /**
     * EndTime 结束时间
     */
    @Id
    @Column(name = "EndTime")
    private Date endtime;

    /**
     * CreateTime 创建时间
     */
    @Column(name = "CreateTime")
    private Date createtime;

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
    private String isdeleted;

    /**
     * AddInfo0 预留字段
     */
    @Column(name = "AddInfo0")
    private String addinfo0;

    /**
     * AddInfo1
     */
    @Column(name = "AddInfo1")
    private String addinfo1;

    /**
     * AddInfo2
     */
    @Column(name = "AddInfo2")
    private String addinfo2;

    /**
     * AddInfo3
     */
    @Column(name = "AddInfo3")
    private String addinfo3;

    /**
     * AddInfo4
     */
    @Column(name = "AddInfo4")
    private String addinfo4;

    /**
     * AddInfo5
     */
    @Column(name = "AddInfo5")
    private String addinfo5;

    /**
     * AddInfo6
     */
    @Column(name = "AddInfo6")
    private String addinfo6;

    /**
     * AddInfo7
     */
    @Column(name = "AddInfo7")
    private String addinfo7;

    /**
     * 获取Id 优惠券id
     *
     * @return Id - Id 优惠券id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置Id 优惠券id
     *
     * @param id Id 优惠券id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取StartTime 开始时间
     *
     * @return StartTime - StartTime 开始时间
     */
    public Date getStarttime() {
        return starttime;
    }

    /**
     * 设置StartTime 开始时间
     *
     * @param starttime StartTime 开始时间
     */
    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    /**
     * 获取EndTime 结束时间
     *
     * @return EndTime - EndTime 结束时间
     */
    public Date getEndtime() {
        return endtime;
    }

    /**
     * 设置EndTime 结束时间
     *
     * @param endtime EndTime 结束时间
     */
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    /**
     * 获取CreateTime 创建时间
     *
     * @return CreateTime - CreateTime 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置CreateTime 创建时间
     *
     * @param createtime CreateTime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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
     * 获取AddInfo0 预留字段
     *
     * @return AddInfo0 - AddInfo0 预留字段
     */
    public String getAddinfo0() {
        return addinfo0;
    }

    /**
     * 设置AddInfo0 预留字段
     *
     * @param addinfo0 AddInfo0 预留字段
     */
    public void setAddinfo0(String addinfo0) {
        this.addinfo0 = addinfo0;
    }

    /**
     * 获取AddInfo1
     *
     * @return AddInfo1 - AddInfo1
     */
    public String getAddinfo1() {
        return addinfo1;
    }

    /**
     * 设置AddInfo1
     *
     * @param addinfo1 AddInfo1
     */
    public void setAddinfo1(String addinfo1) {
        this.addinfo1 = addinfo1;
    }

    /**
     * 获取AddInfo2
     *
     * @return AddInfo2 - AddInfo2
     */
    public String getAddinfo2() {
        return addinfo2;
    }

    /**
     * 设置AddInfo2
     *
     * @param addinfo2 AddInfo2
     */
    public void setAddinfo2(String addinfo2) {
        this.addinfo2 = addinfo2;
    }

    /**
     * 获取AddInfo3
     *
     * @return AddInfo3 - AddInfo3
     */
    public String getAddinfo3() {
        return addinfo3;
    }

    /**
     * 设置AddInfo3
     *
     * @param addinfo3 AddInfo3
     */
    public void setAddinfo3(String addinfo3) {
        this.addinfo3 = addinfo3;
    }

    /**
     * 获取AddInfo4
     *
     * @return AddInfo4 - AddInfo4
     */
    public String getAddinfo4() {
        return addinfo4;
    }

    /**
     * 设置AddInfo4
     *
     * @param addinfo4 AddInfo4
     */
    public void setAddinfo4(String addinfo4) {
        this.addinfo4 = addinfo4;
    }

    /**
     * 获取AddInfo5
     *
     * @return AddInfo5 - AddInfo5
     */
    public String getAddinfo5() {
        return addinfo5;
    }

    /**
     * 设置AddInfo5
     *
     * @param addinfo5 AddInfo5
     */
    public void setAddinfo5(String addinfo5) {
        this.addinfo5 = addinfo5;
    }

    /**
     * 获取AddInfo6
     *
     * @return AddInfo6 - AddInfo6
     */
    public String getAddinfo6() {
        return addinfo6;
    }

    /**
     * 设置AddInfo6
     *
     * @param addinfo6 AddInfo6
     */
    public void setAddinfo6(String addinfo6) {
        this.addinfo6 = addinfo6;
    }

    /**
     * 获取AddInfo7
     *
     * @return AddInfo7 - AddInfo7
     */
    public String getAddinfo7() {
        return addinfo7;
    }

    /**
     * 设置AddInfo7
     *
     * @param addinfo7 AddInfo7
     */
    public void setAddinfo7(String addinfo7) {
        this.addinfo7 = addinfo7;
    }
}