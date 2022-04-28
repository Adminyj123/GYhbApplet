package com.gyhb.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Table(name = "admin_users")
public class AdminUsers implements Serializable {
    /**
     * 用户ID
     */
    @Id
    @Column(name = "userId")
    private String userid;

    /**
     * 用户名称
     */
    @Column(name = "userName")
    private String username;

    /**
     * 用户密码（MD5加密）
     */
    @Column(name = "userPwd")
    private String userpwd;

    /**
     * 用户邮箱
     */
    @Column(name = "userEmail")
    private String useremail;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 性别：-1未知，0-女，1-男
     */
    private Integer sex;

    /**
     * 部门（列表）
     */
    @Column(name = "deptId")
    private String deptid;

    /**
     * 岗位
     */
    private String job;

    /**
     * 用户状态：1-在职，2-离职，3-试用期，4-兼职
     */
    private Integer state;

    /**
     * 用户角色：0-系统管理员，1-普通用户
     */
    private Integer role;

    /**
     * 系统角色（列表）
     */
    @Column(name = "roleList")
    private String rolelist;

    /**
     * 创建时间
     */
    @Column(name = "createTime")
    private Date createtime;

    /**
     * 更新时间（最后上线时间）
     */
    @Column(name = "updateTime")
    private Date updatetime;

    /**
     * 获取用户ID
     *
     * @return userId - 用户ID
     */
    public String getUserid() {
        return userid;
    }

    /**
     * 设置用户ID
     *
     * @param userid 用户ID
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * 获取用户名称
     *
     * @return userName - 用户名称
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名称
     *
     * @param username 用户名称
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取用户密码（MD5加密）
     *
     * @return userPwd - 用户密码（MD5加密）
     */
    public String getUserpwd() {
        return userpwd;
    }

    /**
     * 设置用户密码（MD5加密）
     *
     * @param userpwd 用户密码（MD5加密）
     */
    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    /**
     * 获取用户邮箱
     *
     * @return userEmail - 用户邮箱
     */
    public String getUseremail() {
        return useremail;
    }

    /**
     * 设置用户邮箱
     *
     * @param useremail 用户邮箱
     */
    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    /**
     * 获取手机号
     *
     * @return mobile - 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号
     *
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * 获取性别：-1未知，0-女，1-男
     *
     * @return sex - 性别：-1未知，0-女，1-男
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别：-1未知，0-女，1-男
     *
     * @param sex 性别：-1未知，0-女，1-男
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取部门（列表）
     *
     * @return deptId - 部门（列表）
     */
    public String getDeptid() {
        return deptid;
    }

    /**
     * 设置部门（列表）
     *
     * @param deptid 部门（列表）
     */
    public void setDeptid(String deptid) {
        this.deptid = deptid;
    }

    /**
     * 获取岗位
     *
     * @return job - 岗位
     */
    public String getJob() {
        return job;
    }

    /**
     * 设置岗位
     *
     * @param job 岗位
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * 获取用户状态：1-在职，2-离职，3-试用期，4-兼职
     *
     * @return state - 用户状态：1-在职，2-离职，3-试用期，4-兼职
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置用户状态：1-在职，2-离职，3-试用期，4-兼职
     *
     * @param state 用户状态：1-在职，2-离职，3-试用期，4-兼职
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取用户角色：0-系统管理员，1-普通用户
     *
     * @return role - 用户角色：0-系统管理员，1-普通用户
     */
    public Integer getRole() {
        return role;
    }

    /**
     * 设置用户角色：0-系统管理员，1-普通用户
     *
     * @param role 用户角色：0-系统管理员，1-普通用户
     */
    public void setRole(Integer role) {
        this.role = role;
    }

    /**
     * 获取系统角色（列表）
     *
     * @return roleList - 系统角色（列表）
     */
    public String getRolelist() {
        return rolelist;
    }

    /**
     * 设置系统角色（列表）
     *
     * @param rolelist 系统角色（列表）
     */
    public void setRolelist(String rolelist) {
        this.rolelist = rolelist;
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
     * 获取更新时间（最后上线时间）
     *
     * @return updateTime - 更新时间（最后上线时间）
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置更新时间（最后上线时间）
     *
     * @param updatetime 更新时间（最后上线时间）
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}