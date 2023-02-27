package com.example.jsonschema.validator.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "environment")
public class EnvironmentVariables {
    private String postgresHost;
    private String postgresPort;
    private String postgresDatabase;
    private String postgresUsername;
    private String postgresPassword;

}
