package com.helloworld.epidemicmanagement.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * @author fsyj
 */
@EnableConfigurationProperties(OssConfig.class)
@ConfigurationProperties(prefix = "oss", ignoreInvalidFields = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OssConfig {
    /**
     * AccessKey
     */
    private String accessKey;

    /**
     * 密钥
     */
    private String secretKey;

    /**
     * 存储空间名
     */
    private String ossName;

    /**
     * 空间网址
     */
    private String site;

    /**
     * 空间存储区域
     */
    private String area;

    /**
     * 存储路径
     */
    private String path;

    /**
     * 上传域名
     */
    private String domain;

    /**
     * 上传凭证过期时间
     */
    private Long expire;
}
