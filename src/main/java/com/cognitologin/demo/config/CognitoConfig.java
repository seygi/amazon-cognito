package com.cognitologin.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CognitoConfig {
    @Value("${cognito.user.pool.id}")
    private String cognitoUserPoolId;

    @Value("${cognito.user.pool.client.id}")
    private String cognitoUserPoolClientId;

    public String getCognitoUserPoolId() {
        return cognitoUserPoolId;
    }

    public void setCognitoUserPoolId(String cognitoUserPoolId) {
        this.cognitoUserPoolId = cognitoUserPoolId;
    }

    public String getCognitoUserPoolClientId() {
        return cognitoUserPoolClientId;
    }

    public void setCognitoUserPoolClientId(String cognitoUserPoolClientId) {
        this.cognitoUserPoolClientId = cognitoUserPoolClientId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CognitoConfig{");
        sb.append("cognitoUserPoolId='").append(cognitoUserPoolId).append('\'');
        sb.append(", cognitoUserPoolClientId='").append(cognitoUserPoolClientId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
