package com.gyhb.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "AppletUserOrder")
public class Appletuserorder implements Serializable {
    /**
     * Id
     */
    @Id
    @Column(name = "Id")
    private String id;

    /**
     * 用户id 用户id
     */
    @Column(name = "UserId")
    private String userid;

    /**
     * 订单状态 订单状态
     */
    @Column(name = "OrderStyle")
    private String orderstyle;

    /**
     * 回收类别（父类类别code） 回收类别（父类类别code）
     */
    @Column(name = "ParentCategory")
    private String parentcategory;

    /**
     * 回收类别（子类类别code） 回收类别（子类类别code）
     */
    @Column(name = "Category")
    private String category;

    /**
     * 预估重量 预估重量  需要前后端统一约定   是否使用  （0，1，2，3，4 来代替相应的公斤）
（0：1~25公斤）
（1：25~50公斤）
（2：50~250公斤）
（3：>250公斤）
     */
    @Column(name = "WeightStyle")
    private String weightstyle;

    /**
     * 预约时间 预约时间
     */
    @Column(name = "AppointmentTime")
    private Date appointmenttime;

    /**
     * 回收地址 回收地址
     */
    @Column(name = "Address")
    private String address;

    /**
     * 备注 备注
     */
    @Column(name = "Remark")
    private String remark;

    /**
     * Flag 标志位
     */
    @Column(name = "Flag")
    private String flag;

    /**
     * Validflag 数据有效标志
0：有效
1：无效
     */
    @Column(name = "Validflag")
    private String validflag;

    /**
     * 预留字段0 预留字段0
     */
    @Column(name = "AddInfo0")
    private String addinfo0;

    /**
     * 预留字段1 预留字段1
     */
    @Column(name = "AddInfo1")
    private String addinfo1;

    /**
     * 预留字段2 预留字段2
     */
    @Column(name = "AddInfo2")
    private String addinfo2;

    /**
     * 预留字段3 预留字段3
     */
    @Column(name = "AddInfo3")
    private String addinfo3;

    /**
     * 预留字段4 预留字段4
     */
    @Column(name = "AddInfo4")
    private String addinfo4;

    /**
     * 更新时间 更新时间
     */
    @Column(name = "UPDATED_TIME")
    private Date updatedTime;

    /**
     * 创建时间 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 获取Id
     *
     * @return Id - Id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置Id
     *
     * @param id Id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取用户id 用户id
     *
     * @return UserId - 用户id 用户id
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置用户id 用户id
     *
     * @param userid 用户id 用户id
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 获取订单状态 订单状态
     *
     * @return OrderStyle - 订单状态 订单状态
     */
    public String getOrderstyle() {
        return orderstyle;
    }

    /**
     * 设置订单状态 订单状态
     *
     * @param orderstyle 订单状态 订单状态
     */
    public void setOrderstyle(String orderstyle) {
        this.orderstyle = orderstyle;
    }

    /**
     * 获取回收类别（父类类别code） 回收类别（父类类别code）
     *
     * @return ParentCategory - 回收类别（父类类别code） 回收类别（父类类别code）
     */
    public String getParentcategory() {
        return parentcategory;
    }

    /**
     * 设置回收类别（父类类别code） 回收类别（父类类别code）
     *
     * @param parentcategory 回收类别（父类类别code） 回收类别（父类类别code）
     */
    public void setParentcategory(String parentcategory) {
        this.parentcategory = parentcategory;
    }

    /**
     * 获取回收类别（子类类别code） 回收类别（子类类别code）
     *
     * @return Category - 回收类别（子类类别code） 回收类别（子类类别code）
     */
    public String getCategory() {
        return category;
    }

    /**
     * 设置回收类别（子类类别code） 回收类别（子类类别code）
     *
     * @param category 回收类别（子类类别code） 回收类别（子类类别code）
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * 获取预估重量 预估重量  需要前后端统一约定   是否使用  （0，1，2，3，4 来代替相应的公斤）
（0：1~25公斤）
（1：25~50公斤）
（2：50~250公斤）
（3：>250公斤）
     *
     * @return WeightStyle - 预估重量 预估重量  需要前后端统一约定   是否使用  （0，1，2，3，4 来代替相应的公斤）
（0：1~25公斤）
（1：25~50公斤）
（2：50~250公斤）
（3：>250公斤）
     */
    public String getWeightstyle() {
        return weightstyle;
    }

    /**
     * 设置预估重量 预估重量  需要前后端统一约定   是否使用  （0，1，2，3，4 来代替相应的公斤）
（0：1~25公斤）
（1：25~50公斤）
（2：50~250公斤）
（3：>250公斤）
     *
     * @param weightstyle 预估重量 预估重量  需要前后端统一约定   是否使用  （0，1，2，3，4 来代替相应的公斤）
（0：1~25公斤）
（1：25~50公斤）
（2：50~250公斤）
（3：>250公斤）
     */
    public void setWeightstyle(String weightstyle) {
        this.weightstyle = weightstyle;
    }

    /**
     * 获取预约时间 预约时间
     *
     * @return AppointmentTime - 预约时间 预约时间
     */
    public Date getAppointmenttime() {
        return appointmenttime;
    }

    /**
     * 设置预约时间 预约时间
     *
     * @param appointmenttime 预约时间 预约时间
     */
    public void setAppointmenttime(Date appointmenttime) {
        this.appointmenttime = appointmenttime;
    }

    /**
     * 获取回收地址 回收地址
     *
     * @return Address - 回收地址 回收地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置回收地址 回收地址
     *
     * @param address 回收地址 回收地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取备注 备注
     *
     * @return Remark - 备注 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注 备注
     *
     * @param remark 备注 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取Flag 标志位
     *
     * @return Flag - Flag 标志位
     */
    public String getFlag() {
        return flag;
    }

    /**
     * 设置Flag 标志位
     *
     * @param flag Flag 标志位
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**
     * 获取Validflag 数据有效标志
0：有效
1：无效
     *
     * @return Validflag - Validflag 数据有效标志
0：有效
1：无效
     */
    public String getValidflag() {
        return validflag;
    }

    /**
     * 设置Validflag 数据有效标志
0：有效
1：无效
     *
     * @param validflag Validflag 数据有效标志
0：有效
1：无效
     */
    public void setValidflag(String validflag) {
        this.validflag = validflag;
    }

    /**
     * 获取预留字段0 预留字段0
     *
     * @return AddInfo0 - 预留字段0 预留字段0
     */
    public String getAddinfo0() {
        return addinfo0;
    }

    /**
     * 设置预留字段0 预留字段0
     *
     * @param addinfo0 预留字段0 预留字段0
     */
    public void setAddinfo0(String addinfo0) {
        this.addinfo0 = addinfo0;
    }

    /**
     * 获取预留字段1 预留字段1
     *
     * @return AddInfo1 - 预留字段1 预留字段1
     */
    public String getAddinfo1() {
        return addinfo1;
    }

    /**
     * 设置预留字段1 预留字段1
     *
     * @param addinfo1 预留字段1 预留字段1
     */
    public void setAddinfo1(String addinfo1) {
        this.addinfo1 = addinfo1;
    }

    /**
     * 获取预留字段2 预留字段2
     *
     * @return AddInfo2 - 预留字段2 预留字段2
     */
    public String getAddinfo2() {
        return addinfo2;
    }

    /**
     * 设置预留字段2 预留字段2
     *
     * @param addinfo2 预留字段2 预留字段2
     */
    public void setAddinfo2(String addinfo2) {
        this.addinfo2 = addinfo2;
    }

    /**
     * 获取预留字段3 预留字段3
     *
     * @return AddInfo3 - 预留字段3 预留字段3
     */
    public String getAddinfo3() {
        return addinfo3;
    }

    /**
     * 设置预留字段3 预留字段3
     *
     * @param addinfo3 预留字段3 预留字段3
     */
    public void setAddinfo3(String addinfo3) {
        this.addinfo3 = addinfo3;
    }

    /**
     * 获取预留字段4 预留字段4
     *
     * @return AddInfo4 - 预留字段4 预留字段4
     */
    public String getAddinfo4() {
        return addinfo4;
    }

    /**
     * 设置预留字段4 预留字段4
     *
     * @param addinfo4 预留字段4 预留字段4
     */
    public void setAddinfo4(String addinfo4) {
        this.addinfo4 = addinfo4;
    }

    /**
     * 获取更新时间 更新时间
     *
     * @return UPDATED_TIME - 更新时间 更新时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置更新时间 更新时间
     *
     * @param updatedTime 更新时间 更新时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * 获取创建时间 创建时间
     *
     * @return CREATE_TIME - 创建时间 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间 创建时间
     *
     * @param createTime 创建时间 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}