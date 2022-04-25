package com.gyhb.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "qcloud.cos")
@Configuration
@Data
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

}