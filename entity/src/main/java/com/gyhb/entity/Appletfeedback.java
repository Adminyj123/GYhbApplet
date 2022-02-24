package com.gyhb.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "AppletFeedback")
public class Appletfeedback implements Serializable {
    /**
     * Id
     */
    @Id
    @Column(name = "Id")
    private String id;

    /**
     * 用户ID 用户id
     */
    @Column(name = "UserId")
    private String userid;

    /**
     * 意见类型 意见类型
（0 ：下单问题）
（1： 骑手问题）
（2： 其他）
     */
    @Column(name = "Type")
    private String type;

    /**
     * 联系电话 联系电话
     */
    @Column(name = "Phone")
    private String phone;

    /**
     * 反馈内容 反馈内容
     */
    @Column(name = "Info")
    private String info;

    /**
     * 图片信息 图片信息
     */
    @Column(name = "PicUrl")
    private String picurl;

    /**
     * 数据有效标志位 数据有效标志位
0：有效
1：无效
     */
    @Column(name = "Validflag")
    private String validflag;

    /**
     * 反馈日期 反馈日期
     */
    @Column(name = "Time")
    private Date time;

    /**
     * flag标志 flag标志
     */
    @Column(name = "Flag")
    private String flag;

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
     * 创建时间
     */
    @Column(name = "CREATED_TIME")
    private Date createdTime;

    /**
     * 更新时间
     */
    @Column(name = "UPDATED_TIME")
    private Date updatedTime;

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
     * 获取用户ID 用户id
     *
     * @return UserId - 用户ID 用户id
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置用户ID 用户id
     *
     * @param userid 用户ID 用户id
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 获取意见类型 意见类型
（0 ：下单问题）
（1： 骑手问题）
（2： 其他）
     *
     * @return Type - 意见类型 意见类型
（0 ：下单问题）
（1： 骑手问题）
（2： 其他）
     */
    public String getType() {
        return type;
    }

    /**
     * 设置意见类型 意见类型
（0 ：下单问题）
（1： 骑手问题）
（2： 其他）
     *
     * @param type 意见类型 意见类型
（0 ：下单问题）
（1： 骑手问题）
（2： 其他）
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取联系电话 联系电话
     *
     * @return Phone - 联系电话 联系电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置联系电话 联系电话
     *
     * @param phone 联系电话 联系电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取反馈内容 反馈内容
     *
     * @return Info - 反馈内容 反馈内容
     */
    public String getInfo() {
        return info;
    }

    /**
     * 设置反馈内容 反馈内容
     *
     * @param info 反馈内容 反馈内容
     */
    public void setInfo(String info) {
        this.info = info;
    }

    /**
     * 获取图片信息 图片信息
     *
     * @return PicUrl - 图片信息 图片信息
     */
    public String getPicurl() {
        return picurl;
    }

    /**
     * 设置图片信息 图片信息
     *
     * @param picurl 图片信息 图片信息
     */
    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }

    /**
     * 获取数据有效标志位 数据有效标志位
0：有效
1：无效
     *
     * @return Validflag - 数据有效标志位 数据有效标志位
0：有效
1：无效
     */
    public String getValidflag() {
        return validflag;
    }

    /**
     * 设置数据有效标志位 数据有效标志位
0：有效
1：无效
     *
     * @param validflag 数据有效标志位 数据有效标志位
0：有效
1：无效
     */
    public void setValidflag(String validflag) {
        this.validflag = validflag;
    }

    /**
     * 获取反馈日期 反馈日期
     *
     * @return Time - 反馈日期 反馈日期
     */
    public Date getTime() {
        return time;
    }

    /**
     * 设置反馈日期 反馈日期
     *
     * @param time 反馈日期 反馈日期
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 获取flag标志 flag标志
     *
     * @return Flag - flag标志 flag标志
     */
    public String getFlag() {
        return flag;
    }

    /**
     * 设置flag标志 flag标志
     *
     * @param flag flag标志 flag标志
     */
    public void setFlag(String flag) {
        this.flag = flag;
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
     * 获取创建时间
     *
     * @return CREATED_TIME - 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置创建时间
     *
     * @param createdTime 创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取更新时间
     *
     * @return UPDATED_TIME - 更新时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置更新时间
     *
     * @param updatedTime 更新时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}