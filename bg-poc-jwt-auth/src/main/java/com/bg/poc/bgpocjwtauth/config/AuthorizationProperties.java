package com.bg.poc.bgpocjwtauth.config;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "bg.users.authorization", name = "enabled")
@ConfigurationProperties(prefix = "bg.users.authorization")
@Data
public class AuthorizationProperties {

    @NotEmpty
    private String clientId;

    private String clientSecret;

    private String scope;

    private int accessTokenValiditySeconds;

    private int refreshTokenValiditySeconds;

}
