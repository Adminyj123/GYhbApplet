package com.gyhb.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "AppletMallTraceword")
public class Appletmalltraceword {
    /**
     * Id ID
     */
    @Id
    @Column(name = "Id")
    private String id;

    /**
     * Hot 热词标志
     */
    @Column(name = "Hot")
    private String hot;

    /**
     * Weight 权重/排序
     */
    @Column(name = "Weight")
    private String weight;

    /**
     * QueryName 查询名称
     */
    @Column(name = "QueryName")
    private String queryname;

    /**
     * QueryType 查询类型
     */
    @Column(name = "QueryType")
    private String querytype;

    /**
     * Num 出现次数
     */
    @Column(name = "Num")
    private Integer num;

    /**
     * CreateTime 新增时间
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
     * 获取Id ID
     *
     * @return Id - Id ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置Id ID
     *
     * @param id Id ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取Hot 热词标志
     *
     * @return Hot - Hot 热词标志
     */
    public String getHot() {
        return hot;
    }

    /**
     * 设置Hot 热词标志
     *
     * @param hot Hot 热词标志
     */
    public void setHot(String hot) {
        this.hot = hot;
    }

    /**
     * 获取Weight 权重/排序
     *
     * @return Weight - Weight 权重/排序
     */
    public String getWeight() {
        return weight;
    }

    /**
     * 设置Weight 权重/排序
     *
     * @param weight Weight 权重/排序
     */
    public void setWeight(String weight) {
        this.weight = weight;
    }

    /**
     * 获取QueryName 查询名称
     *
     * @return QueryName - QueryName 查询名称
     */
    public String getQueryname() {
        return queryname;
    }

    /**
     * 设置QueryName 查询名称
     *
     * @param queryname QueryName 查询名称
     */
    public void setQueryname(String queryname) {
        this.queryname = queryname;
    }

    /**
     * 获取QueryType 查询类型
     *
     * @return QueryType - QueryType 查询类型
     */
    public String getQuerytype() {
        return querytype;
    }

    /**
     * 设置QueryType 查询类型
     *
     * @param querytype QueryType 查询类型
     */
    public void setQuerytype(String querytype) {
        this.querytype = querytype;
    }

    /**
     * 获取Num 出现次数
     *
     * @return Num - Num 出现次数
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 设置Num 出现次数
     *
     * @param num Num 出现次数
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 获取CreateTime 新增时间
     *
     * @return CreateTime - CreateTime 新增时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置CreateTime 新增时间
     *
     * @param createtime CreateTime 新增时间
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