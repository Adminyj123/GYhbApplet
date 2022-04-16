package com.gyhb.entity.bo;

public class UserInfoVo {

    private String language;
    private String nickName;
    private Integer gender;

    private String city;
    private String province;
    private String country;
    private String avatarUrl;
    public watermark watermark;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public com.gyhb.entity.bo.watermark getWatermark() {
        return watermark;
    }

    public void setWatermark(com.gyhb.entity.bo.watermark watermark) {
        this.watermark = watermark;
    }
}
