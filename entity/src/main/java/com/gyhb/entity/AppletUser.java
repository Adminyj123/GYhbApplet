package com.gyhb.entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @description appletuser
 * @author
 * @date 2022-02-17
 */
@Table(name = "AppletUser")
public class AppletUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    /**
     * id
     */
    private String id;

    /**
     * 姓名 姓名
     */
    private String name;

    /**
     * 年龄 年龄
     */
    private String age;

    /**
     * 性别 性别 0：男  1：女
     */
    private String sex;

    /**
     * 身份证号 身份证号
     */
    private String idcard;

    /**
     * 籍贯 籍贯
     */
    private String nativeplace;

    /**
     * 昵称 昵称
     */
    private String nickname;

    /**
     * 微信号 微信号
     */
    private String wechatnumber;

    /**
     * 电话号码 电话号码
     */
    private String telephone;

    /**
     * 头像地址 头像地址
     */
    private String avatarurl;

    /**
     * 数据有效标志位 数据有效标志位
     */
    private String validflag;

    /**
     * flag标志 flag标志
     */
    private String flag;

    /**
     * 预留字段0 预留字段0
     */
    private String addinfo0;

    /**
     * 预留字段1 预留字段1
     */
    private String addinfo1;

    /**
     * 预留字段2 预留字段2
     */
    private String addinfo2;

    /**
     * 预留字段3 预留字段3
     */
    private String addinfo3;

    /**
     * 预留字段4 预留字段4
     */
    private String addinfo4;

    /**
     * 创建时间
     */
    private Date createdTime;

    /**
     * 更新时间
     */
    private Date updatedTime;

    public AppletUser() {}

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getNativeplace() {
        return nativeplace;
    }

    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getWechatnumber() {
        return wechatnumber;
    }

    public void setWechatnumber(String wechatnumber) {
        this.wechatnumber = wechatnumber;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl;
    }

    public String getValidflag() {
        return validflag;
    }

    public void setValidflag(String validflag) {
        this.validflag = validflag;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getAddinfo0() {
        return addinfo0;
    }

    public void setAddinfo0(String addinfo0) {
        this.addinfo0 = addinfo0;
    }

    public String getAddinfo1() {
        return addinfo1;
    }

    public void setAddinfo1(String addinfo1) {
        this.addinfo1 = addinfo1;
    }

    public String getAddinfo2() {
        return addinfo2;
    }

    public void setAddinfo2(String addinfo2) {
        this.addinfo2 = addinfo2;
    }

    public String getAddinfo3() {
        return addinfo3;
    }

    public void setAddinfo3(String addinfo3) {
        this.addinfo3 = addinfo3;
    }

    public String getAddinfo4() {
        return addinfo4;
    }

    public void setAddinfo4(String addinfo4) {
        this.addinfo4 = addinfo4;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}