package com.gyhb.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "AppletCategory")
public class Appletcategory implements Serializable {
    /**
     * Id
     */
    @Id
    @Column(name = "Id")
    private String id;

    /**
     * ParentCode 父类code
     */
    @Column(name = "ParentCode")
    private String parentcode;

    /**
     * Code code
     */
    @Column(name = "Code")
    private String code;

    /**
     * 名称 名称
     */
    @Column(name = "Name")
    private String name;

    /**
     * Flag 标志位
     */
    @Column(name = "Flag")
    private String flag;

    /**
     * 数据有效标志位 数据有效标志
0：有效
1：无效
     */
    @Column(name = "Validflag")
    private String validflag;

    /**
     * 价格 价格（以公斤作为基础）
     */
    @Column(name = "Price")
    private BigDecimal price;

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
     * 获取ParentCode 父类code
     *
     * @return ParentCode - ParentCode 父类code
     */
    public String getParentcode() {
        return parentcode;
    }

    /**
     * 设置ParentCode 父类code
     *
     * @param parentcode ParentCode 父类code
     */
    public void setParentcode(String parentcode) {
        this.parentcode = parentcode;
    }

    /**
     * 获取Code code
     *
     * @return Code - Code code
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置Code code
     *
     * @param code Code code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取名称 名称
     *
     * @return Name - 名称 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称 名称
     *
     * @param name 名称 名称
     */
    public void setName(String name) {
        this.name = name;
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
     * 获取数据有效标志位 数据有效标志
0：有效
1：无效
     *
     * @return Validflag - 数据有效标志位 数据有效标志
0：有效
1：无效
     */
    public String getValidflag() {
        return validflag;
    }

    /**
     * 设置数据有效标志位 数据有效标志
0：有效
1：无效
     *
     * @param validflag 数据有效标志位 数据有效标志
0：有效
1：无效
     */
    public void setValidflag(String validflag) {
        this.validflag = validflag;
    }

    /**
     * 获取价格 价格（以公斤作为基础）
     *
     * @return Price - 价格 价格（以公斤作为基础）
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置价格 价格（以公斤作为基础）
     *
     * @param price 价格 价格（以公斤作为基础）
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
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


    public Appletcategory(String parentcode, String code, String name) {
        this.parentcode = parentcode;
        this.code = code;
        this.name = name;
    }

    public Appletcategory(String id, String parentcode, String code, String name, String flag, String validflag, BigDecimal price, String addinfo0, String addinfo1, String addinfo2, String addinfo3, String addinfo4, Date updatedTime, Date createTime) {
        this.id = id;
        this.parentcode = parentcode;
        this.code = code;
        this.name = name;
        this.flag = flag;
        this.validflag = validflag;
        this.price = price;
        this.addinfo0 = addinfo0;
        this.addinfo1 = addinfo1;
        this.addinfo2 = addinfo2;
        this.addinfo3 = addinfo3;
        this.addinfo4 = addinfo4;
        this.updatedTime = updatedTime;
        this.createTime = createTime;
    }

    public Appletcategory() {
    }
}