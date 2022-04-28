package com.gyhb.entity.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户对象BO", description = "从客户端，由用户传入的数据封装在此entity中")
public class AdminUserBO {

    @ApiModelProperty(value = "用户名", name = "username", example = "yh001", required = true)
    private String username;
    @ApiModelProperty(value = "密码", name = "userpwd", example = "123456", required = true)
    private String userpwd;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public AdminUserBO(String username, String userpwd) {
        this.username = username;
        this.userpwd = userpwd;
    }
}
