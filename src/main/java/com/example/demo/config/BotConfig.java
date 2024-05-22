package com.example.demo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class BotConfig {

    @Value("${bot-credentials.name}")
    String botName;

    @Value("${bot-credentials.token}")
    String token;

    @Value("${bot-credentials.owner}")
    long owner;

}
