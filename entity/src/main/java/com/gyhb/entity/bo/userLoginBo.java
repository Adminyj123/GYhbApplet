package com.gyhb.entity.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.models.auth.In;

import java.util.List;

@ApiModel(value = "用户登录成功后的vo", description = "登录成功后返回的实体")
public class userLoginBo {

    private String userId;
    private String userName;
    private String userEmail;
    private Integer state;
    private String deptId;
    private Integer role;
    private String token;
    private List roleList;

    public userLoginBo() {};

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List getRoleList() {
        return roleList;
    }

    public void setRoleList(List roleList) {
        this.roleList = roleList;
    }
}
