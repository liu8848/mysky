package com.sky.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sky.jwt")
@Data
public class JwtProperties {
    /**
     * 管理段生成jwt相关配置
     */
    private String adminSecretKey;
    private long adminTtl;
    private String adminTokenName;
}
