package com.gyhb.utils.utils;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

@ConfigurationProperties(prefix = "qcloud.cos")
@Configuration
public class COSConfig {

    /**
     * 腾讯云的SecretId
     */
    private String secretId;

    /**
     * 腾讯云的secretKey
     */
    private String secretKey;

    /**
     * 存储桶的名称
     */
    private String bucketName;

    /**
     * bucket所在地区区域
     */
    private String bucketRegion;

    public String getSecretId() {
        return secretId;
    }

    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getBucketRegion() {
        return bucketRegion;
    }

    public void setBucketRegion(String bucketRegion) {
        this.bucketRegion = bucketRegion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        COSConfig cosConfig = (COSConfig) o;
        return Objects.equals(secretId, cosConfig.secretId) && Objects.equals(secretKey, cosConfig.secretKey) && Objects.equals(bucketName, cosConfig.bucketName) && Objects.equals(bucketRegion, cosConfig.bucketRegion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(secretId, secretKey, bucketName, bucketRegion);
    }
}