package com.gyhb.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "AppletPassward")
public class Appletpassward {
    /**
     * Id Id
     */
    @Id
    @Column(name = "Id")
    private String id;

    /**
     * Passward Passward
     */
    @Id
    @Column(name = "Passward")
    private String passward;

    /**
     * 获取Id Id
     *
     * @return Id - Id Id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置Id Id
     *
     * @param id Id Id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取Passward Passward
     *
     * @return Passward - Passward Passward
     */
    public String getPassward() {
        return passward;
    }

    /**
     * 设置Passward Passward
     *
     * @param passward Passward Passward
     */
    public void setPassward(String passward) {
        this.passward = passward;
    }
}