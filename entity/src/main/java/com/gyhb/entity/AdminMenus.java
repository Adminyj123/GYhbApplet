package com.gyhb.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "admin_menus")
public class AdminMenus implements Serializable {
    @Id
    @Column(name = "menuId")
    private String menuid;

    /**
     * 菜单类型：1-菜单，2-按钮
     */
    @Column(name = "menuType")
    private Integer menutype;

    /**
     * 菜单名称
     */
    @Column(name = "menuName")
    private String menuname;

    /**
     * 菜单标识符（只有按钮类型才有，用于确认按钮权限）
     */
    @Column(name = "menuCode")
    private String menucode;

    /**
     * 菜单路由（URL中展示路径）
     */
    private String path;

    /**
     * 菜单图标（elementPlus 中图标组件的名称）
     */
    private String icon;

    /**
     * 菜单排序
     */
    private Integer sort;

    /**
     * 组件地址（开头没有/，用于动态组件）
     */
    private String component;

    /**
     * 父菜单ID（列表，一级菜单默认为null）
     */
    @Column(name = "parentId")
    private String parentid;

    /**
     * 菜单状态（0-停用，1-正常）
     */
    @Column(name = "menuState")
    private Integer menustate;

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
     * @return menuId
     */
    public String getMenuid() {
        return menuid;
    }

    /**
     * @param menuid
     */
    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }

    /**
     * 获取菜单类型：1-菜单，2-按钮
     *
     * @return menuType - 菜单类型：1-菜单，2-按钮
     */
    public Integer getMenutype() {
        return menutype;
    }

    /**
     * 设置菜单类型：1-菜单，2-按钮
     *
     * @param menutype 菜单类型：1-菜单，2-按钮
     */
    public void setMenutype(Integer menutype) {
        this.menutype = menutype;
    }

    /**
     * 获取菜单名称
     *
     * @return menuName - 菜单名称
     */
    public String getMenuname() {
        return menuname;
    }

    /**
     * 设置菜单名称
     *
     * @param menuname 菜单名称
     */
    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    /**
     * 获取菜单标识符（只有按钮类型才有，用于确认按钮权限）
     *
     * @return menuCode - 菜单标识符（只有按钮类型才有，用于确认按钮权限）
     */
    public String getMenucode() {
        return menucode;
    }

    /**
     * 设置菜单标识符（只有按钮类型才有，用于确认按钮权限）
     *
     * @param menucode 菜单标识符（只有按钮类型才有，用于确认按钮权限）
     */
    public void setMenucode(String menucode) {
        this.menucode = menucode;
    }

    /**
     * 获取菜单路由（URL中展示路径）
     *
     * @return path - 菜单路由（URL中展示路径）
     */
    public String getPath() {
        return path;
    }

    /**
     * 设置菜单路由（URL中展示路径）
     *
     * @param path 菜单路由（URL中展示路径）
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取菜单图标（elementPlus 中图标组件的名称）
     *
     * @return icon - 菜单图标（elementPlus 中图标组件的名称）
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置菜单图标（elementPlus 中图标组件的名称）
     *
     * @param icon 菜单图标（elementPlus 中图标组件的名称）
     */
    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * 获取菜单排序
     *
     * @return sort - 菜单排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置菜单排序
     *
     * @param sort 菜单排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取组件地址（开头没有/，用于动态组件）
     *
     * @return component - 组件地址（开头没有/，用于动态组件）
     */
    public String getComponent() {
        return component;
    }

    /**
     * 设置组件地址（开头没有/，用于动态组件）
     *
     * @param component 组件地址（开头没有/，用于动态组件）
     */
    public void setComponent(String component) {
        this.component = component;
    }

    /**
     * 获取父菜单ID（列表，一级菜单默认为null）
     *
     * @return parentId - 父菜单ID（列表，一级菜单默认为null）
     */
    public String getParentid() {
        return parentid;
    }

    /**
     * 设置父菜单ID（列表，一级菜单默认为null）
     *
     * @param parentid 父菜单ID（列表，一级菜单默认为null）
     */
    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    /**
     * 获取菜单状态（0-停用，1-正常）
     *
     * @return menuState - 菜单状态（0-停用，1-正常）
     */
    public Integer getMenustate() {
        return menustate;
    }

    /**
     * 设置菜单状态（0-停用，1-正常）
     *
     * @param menustate 菜单状态（0-停用，1-正常）
     */
    public void setMenustate(Integer menustate) {
        this.menustate = menustate;
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