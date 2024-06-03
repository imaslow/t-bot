package com.example.demo.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "bot-credentials")
public class BotCredentialsProperties {

    private String name;

    private String token;

    private Long owner;

}
