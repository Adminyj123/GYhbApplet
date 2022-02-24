package com.gyhb.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "AppletPartner")
public class Appletpartner implements Serializable {
    /**
     * Id
     */
    @Id
    @Column(name = "Id")
    private String id;

    /**
     * 邀请人 邀请人id
     */
    @Column(name = "UserId")
    private String userid;

    /**
     * 姓名 姓名
     */
    @Column(name = "Name")
    private String name;

    /**
     * 年龄 年龄
     */
    @Column(name = "Age")
    private String age;

    /**
     * 性别 性别  0：男   1：女
     */
    @Column(name = "Sex")
    private String sex;

    /**
     * 身份证号 身份证号
     */
    @Column(name = "IDcard")
    private String idcard;

    /**
     * 籍贯 籍贯
     */
    @Column(name = "NativePlace")
    private String nativeplace;

    /**
     * 昵称 昵称
     */
    @Column(name = "Nickname")
    private String nickname;

    /**
     * 微信号 微信号
     */
    @Column(name = "WechatNumber")
    private String wechatnumber;


    /**
     * 电话号码 电话号码
     */
    @Column(name = "Telephone")
    private String telephone;

    /**
     * 头像地址 头像地址
     */
    @Column(name = "AvatarUrl")
    private String avatarurl;


    /**
     * 数据有效标志位 数据有效标志位
0：有效
1：无效
     */
    @Column(name = "Validflag")
    private String validflag;

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
     * 获取邀请人 邀请人id
     *
     * @return UserId - 邀请人 邀请人id
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置邀请人 邀请人id
     *
     * @param userid 邀请人 邀请人id
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 获取姓名 姓名
     *
     * @return Name - 姓名 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名 姓名
     *
     * @param name 姓名 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取年龄 年龄
     *
     * @return Age - 年龄 年龄
     */
    public String getAge() {
        return age;
    }

    /**
     * 设置年龄 年龄
     *
     * @param age 年龄 年龄
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * 获取性别 性别  0：男   1：女
     *
     * @return Sex - 性别 性别  0：男   1：女
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别 性别  0：男   1：女
     *
     * @param sex 性别 性别  0：男   1：女
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取身份证号 身份证号
     *
     * @return IDcard - 身份证号 身份证号
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * 设置身份证号 身份证号
     *
     * @param idcard 身份证号 身份证号
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    /**
     * 获取籍贯 籍贯
     *
     * @return NativePlace - 籍贯 籍贯
     */
    public String getNativeplace() {
        return nativeplace;
    }

    /**
     * 设置籍贯 籍贯
     *
     * @param nativeplace 籍贯 籍贯
     */
    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace;
    }

    /**
     * 获取昵称 昵称
     *
     * @return Nickname - 昵称 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称 昵称
     *
     * @param nickname 昵称 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取微信号 微信号
     *
     * @return WechatNumber - 微信号 微信号
     */
    public String getWechatnumber() {
        return wechatnumber;
    }

    /**
     * 设置微信号 微信号
     *
     * @param wechatnumber 微信号 微信号
     */
    public void setWechatnumber(String wechatnumber) {
        this.wechatnumber = wechatnumber;
    }

    /**
     * 获取电话号码 电话号码
     *
     * @return Telephone - 电话号码 电话号码
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 设置电话号码 电话号码
     *
     * @param telephone 电话号码 电话号码
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    /**
     * 获取头像地址 头像地址
     *
     * @return AvatarUrl - 头像地址 头像地址
     */
    public String getAvatarurl() {
        return avatarurl;
    }

    /**
     * 设置头像地址 头像地址
     *
     * @param avatarurl 头像地址 头像地址
     */
    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
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