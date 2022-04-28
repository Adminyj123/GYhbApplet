package com.gyhb.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "admin_roles")
public class AdminRoles implements Serializable {

    @Id
    @Column(name = "roleId")
    private String roleid;

    /**
     * 角色名称
     */
    @Column(name = "roleName")
    private String rolename;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 角色排序
     */
    private Integer sort;

    /**
     * 角色状态（1-正常）
     */
    private Integer state;

    /**
     * 权限列表【checkedKeys-选中的子菜单对象，halfCheckedKeys-半选中的父菜单】
     */
    @Column(name = "permissionList")
    private String permissionlist;

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
     * @return roleId
     */
    public String getRoleid() {
        return roleid;
    }

    /**
     * @param roleid
     */
    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    /**
     * 获取角色名称
     *
     * @return roleName - 角色名称
     */
    public String getRolename() {
        return rolename;
    }

    /**
     * 设置角色名称
     *
     * @param rolename 角色名称
     */
    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    /**
     * 获取备注信息
     *
     * @return remark - 备注信息
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注信息
     *
     * @param remark 备注信息
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取角色排序
     *
     * @return sort - 角色排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置角色排序
     *
     * @param sort 角色排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取角色状态（1-正常）
     *
     * @return state - 角色状态（1-正常）
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置角色状态（1-正常）
     *
     * @param state 角色状态（1-正常）
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取权限列表【checkedKeys-选中的子菜单对象，halfCheckedKeys-半选中的父菜单】
     *
     * @return permissionList - 权限列表【checkedKeys-选中的子菜单对象，halfCheckedKeys-半选中的父菜单】
     */
    public String getPermissionlist() {
        return permissionlist;
    }

    /**
     * 设置权限列表【checkedKeys-选中的子菜单对象，halfCheckedKeys-半选中的父菜单】
     *
     * @param permissionlist 权限列表【checkedKeys-选中的子菜单对象，halfCheckedKeys-半选中的父菜单】
     */
    public void setPermissionlist(String permissionlist) {
        this.permissionlist = permissionlist;
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