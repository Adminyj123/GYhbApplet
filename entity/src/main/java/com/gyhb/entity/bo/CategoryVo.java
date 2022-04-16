package com.gyhb.entity.bo;

import com.gyhb.entity.Appletcategory;

import java.util.List;

public class CategoryVo {

    private String code;
    private String name;

    private List<Appletcategory> Appletcategory;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<com.gyhb.entity.Appletcategory> getAppletcategory() {
        return Appletcategory;
    }

    public void setAppletcategory(List<com.gyhb.entity.Appletcategory> appletcategory) {
        Appletcategory = appletcategory;
    }
}
