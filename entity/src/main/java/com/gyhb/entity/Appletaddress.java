package com.gyhb.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "AppletAddress")
public class Appletaddress implements Serializable {
    /**
     * Id
     */
    @Id
    @Column(name = "Id")
    private String id;

    /**
     * 用户Id 用户id
     */
    @Column(name = "UserId")
    private String userid;

    /**
     * 联系人 联系人
     */
    @Column(name = "Name")
    private String name;

    /**
     * 手机号码 手机号码
     */
    @Column(name = "Phone")
    private String phone;

    /**
     * 省市区 省市区
     */
    @Column(name = "Provinces")
    private String provinces;

    /**
     * 所属街道 街道
     */
    @Column(name = "Street")
    private String street;

    /**
     * 回收地址 回收地址
     */
    @Column(name = "Address")
    private String address;

    /**
     * 详细地址 详细地址
     */
    @Column(name = "DetailedAddress")
    private String detailedaddress;

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
     * 获取用户Id 用户id
     *
     * @return UserId - 用户Id 用户id
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置用户Id 用户id
     *
     * @param userid 用户Id 用户id
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 获取联系人 联系人
     *
     * @return Name - 联系人 联系人
     */
    public String getName() {
        return name;
    }

    /**
     * 设置联系人 联系人
     *
     * @param name 联系人 联系人
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取手机号码 手机号码
     *
     * @return Phone - 手机号码 手机号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号码 手机号码
     *
     * @param phone 手机号码 手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取省市区 省市区
     *
     * @return Provinces - 省市区 省市区
     */
    public String getProvinces() {
        return provinces;
    }

    /**
     * 设置省市区 省市区
     *
     * @param provinces 省市区 省市区
     */
    public void setProvinces(String provinces) {
        this.provinces = provinces;
    }

    /**
     * 获取所属街道 街道
     *
     * @return Street - 所属街道 街道
     */
    public String getStreet() {
        return street;
    }

    /**
     * 设置所属街道 街道
     *
     * @param street 所属街道 街道
     */
    public void setStreet(String street) {
        this.street = street;
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
     * 获取详细地址 详细地址
     *
     * @return DetailedAddress - 详细地址 详细地址
     */
    public String getDetailedaddress() {
        return detailedaddress;
    }

    /**
     * 设置详细地址 详细地址
     *
     * @param detailedaddress 详细地址 详细地址
     */
    public void setDetailedaddress(String detailedaddress) {
        this.detailedaddress = detailedaddress;
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