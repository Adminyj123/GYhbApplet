package com.gyhb.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "admin_depts")
public class AdminDepts implements Serializable {
    @Id
    @Column(name = "deptId")
    private String deptid;

    /**
     * 父对象ID（列表，一级部门默认为null）
     */
    @Column(name = "parentId")
    private String parentid;

    /**
     * 部门名称
     */
    @Column(name = "deptName")
    private String deptname;

    /**
     * 备注
     */
    private String remark;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 负责人ID
     */
    @Column(name = "userId")
    private String userid;

    /**
     * 负责人名称
     */
    @Column(name = "userName")
    private String username;

    /**
     * 负责人邮箱
     */
    @Column(name = "userEmail")
    private String useremail;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private Date createtime;

    /**
     * 更新时间
     */
    @Column(name = "updateTime")
    private Date updatetime;

    /**
     * @return deptId
     */
    public String getDeptid() {
        return deptid;
    }

    /**
     * @param deptid
     */
    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    /**
     * 获取父对象ID（列表，一级部门默认为null）
     *
     * @return parentId - 父对象ID（列表，一级部门默认为null）
     */
    public String getParentid() {
        return parentid;
    }

    /**
     * 设置父对象ID（列表，一级部门默认为null）
     *
     * @param parentid 父对象ID（列表，一级部门默认为null）
     */
    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    /**
     * 获取部门名称
     *
     * @return deptName - 部门名称
     */
    public String getDeptname() {
        return deptname;
    }

    /**
     * 设置部门名称
     *
     * @param deptname 部门名称
     */
    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取负责人ID
     *
     * @return userId - 负责人ID
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置负责人ID
     *
     * @param userid 负责人ID
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 获取负责人名称
     *
     * @return userName - 负责人名称
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置负责人名称
     *
     * @param username 负责人名称
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取负责人邮箱
     *
     * @return userEmail - 负责人邮箱
     */
    public String getUseremail() {
        return useremail;
    }

    /**
     * 设置负责人邮箱
     *
     * @param useremail 负责人邮箱
     */
    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    /**
     * 获取创建时间
     *
     * @return createTime - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取更新时间
     *
     * @return updateTime - 更新时间
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置更新时间
     *
     * @param updatetime 更新时间
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}