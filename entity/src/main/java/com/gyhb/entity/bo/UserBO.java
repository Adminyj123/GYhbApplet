package com.gyhb.entity.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户对象BO", description = "从客户端，由用户传入的数据封装在此entity中")
public class UserBO {

    @ApiModelProperty(value = "微信号", name = "wechatNumber", example = "wx00001", required = true)
    private String wechatNumber;
    @ApiModelProperty(value = "密码", name = "password", example = "123456", required = true)
    private String password;
    @ApiModelProperty(value = "确认密码", name = "confirmPassword", example = "123456", required = false)
    private String confirmPassword;

    /**
     * 姓名 姓名
     */
    @ApiModelProperty(value = "姓名", name = "name", example = "张三", required = false)
    private String name;

    /**
     * 年龄 年龄
     */
    @ApiModelProperty(value = "年龄", name = "age", example = "23", required = false)
    private String age;

    /**
     * 性别 性别 0：男  1：女
     */
    private String sex;


    /**
     * 电话号码 电话号码
     */
    private String telephone;

    /**
     * 头像地址 头像地址
     */
    @ApiModelProperty(value = "头像", name = "avatarurl", example = "", required = false)
    private String avatarUrl;

    /**
     * 身份证号 身份证号
     */
    private String idCard;

    /**
     * 籍贯 籍贯
     */
    private String nativePlace;

    /**
     * 昵称 昵称
     */
    private String nickname;


    public String getWechatNumber() {
        return wechatNumber;
    }

    public void setWechatNumber(String wechatNumber) {
        this.wechatNumber = wechatNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getNativePlace() {
        return nativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public UserBO(String wechatNumber, String password, String confirmPassword, String name, String age, String sex, String telephone, String avatarUrl, String idCard, String nativePlace, String nickname) {
        this.wechatNumber = wechatNumber;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.telephone = telephone;
        this.avatarUrl = avatarUrl;
        this.idCard = idCard;
        this.nativePlace = nativePlace;
        this.nickname = nickname;
    }
}
