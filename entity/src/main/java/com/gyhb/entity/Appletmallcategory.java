package com.gyhb.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "AppletMallCategory")
public class Appletmallcategory {
    /**
     * Id 列表Id
     */
    @Id
    @Column(name = "Id")
    private String id;

    /**
     * Name 列表名称
     */
    @Column(name = "Name")
    private String name;

    /**
     * Sort 排序
     */
    @Column(name = "Sort")
    private Integer sort;

    /**
     * ClassificationLevel 分类级别
     */
    @Column(name = "ClassificationLevel")
    private String classificationlevel;

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
    private Integer status;

    /**
     * IsDeleted 删除标志位（0：正常，1：删除）
     */
    @Column(name = "IsDeleted")
    private Integer isdeleted;

    /**
     * AddInfo0 预留字段
     */
    @Column(name = "AddInfo0")
    private String addinfo0;

    /**
     * AddInfo1 预留字段
     */
    @Column(name = "AddInfo1")
    private String addinfo1;

    /**
     * AddInfo2 预留字段
     */
    @Column(name = "AddInfo2")
    private String addinfo2;

    /**
     * AddInfo3 预留字段
     */
    @Column(name = "AddInfo3")
    private String addinfo3;

    /**
     * AddInfo4 预留字段
     */
    @Column(name = "AddInfo4")
    private String addinfo4;

    /**
     * 获取Id 列表Id
     *
     * @return Id - Id 列表Id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置Id 列表Id
     *
     * @param id Id 列表Id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取Name 列表名称
     *
     * @return Name - Name 列表名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置Name 列表名称
     *
     * @param name Name 列表名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取Sort 排序
     *
     * @return Sort - Sort 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置Sort 排序
     *
     * @param sort Sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取ClassificationLevel 分类级别
     *
     * @return ClassificationLevel - ClassificationLevel 分类级别
     */
    public String getClassificationlevel() {
        return classificationlevel;
    }

    /**
     * 设置ClassificationLevel 分类级别
     *
     * @param classificationlevel ClassificationLevel 分类级别
     */
    public void setClassificationlevel(String classificationlevel) {
        this.classificationlevel = classificationlevel;
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
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置Status 状态标志位（0：正常，1：不正常）
     *
     * @param status Status 状态标志位（0：正常，1：不正常）
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取IsDeleted 删除标志位（0：正常，1：删除）
     *
     * @return IsDeleted - IsDeleted 删除标志位（0：正常，1：删除）
     */
    public Integer getIsdeleted() {
        return isdeleted;
    }

    /**
     * 设置IsDeleted 删除标志位（0：正常，1：删除）
     *
     * @param isdeleted IsDeleted 删除标志位（0：正常，1：删除）
     */
    public void setIsdeleted(Integer isdeleted) {
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
     * 获取AddInfo1 预留字段
     *
     * @return AddInfo1 - AddInfo1 预留字段
     */
    public String getAddinfo1() {
        return addinfo1;
    }

    /**
     * 设置AddInfo1 预留字段
     *
     * @param addinfo1 AddInfo1 预留字段
     */
    public void setAddinfo1(String addinfo1) {
        this.addinfo1 = addinfo1;
    }

    /**
     * 获取AddInfo2 预留字段
     *
     * @return AddInfo2 - AddInfo2 预留字段
     */
    public String getAddinfo2() {
        return addinfo2;
    }

    /**
     * 设置AddInfo2 预留字段
     *
     * @param addinfo2 AddInfo2 预留字段
     */
    public void setAddinfo2(String addinfo2) {
        this.addinfo2 = addinfo2;
    }

    /**
     * 获取AddInfo3 预留字段
     *
     * @return AddInfo3 - AddInfo3 预留字段
     */
    public String getAddinfo3() {
        return addinfo3;
    }

    /**
     * 设置AddInfo3 预留字段
     *
     * @param addinfo3 AddInfo3 预留字段
     */
    public void setAddinfo3(String addinfo3) {
        this.addinfo3 = addinfo3;
    }

    /**
     * 获取AddInfo4 预留字段
     *
     * @return AddInfo4 - AddInfo4 预留字段
     */
    public String getAddinfo4() {
        return addinfo4;
    }

    /**
     * 设置AddInfo4 预留字段
     *
     * @param addinfo4 AddInfo4 预留字段
     */
    public void setAddinfo4(String addinfo4) {
        this.addinfo4 = addinfo4;
    }
}