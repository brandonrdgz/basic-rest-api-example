package com.rodua.basic_rest_api_example.config.security;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@Validated
@Configuration
@ConfigurationProperties(prefix = "rodua.jwt")
public class JwtConfig {
    @NotNull
    private String secret;

    @NotNull
    private long expiration;
}
