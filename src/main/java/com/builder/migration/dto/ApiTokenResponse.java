package com.builder.migration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiTokenResponse {
    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("refresh_token")
    private String refreshToken;

    private String scope;

    @JsonProperty("token_type")
    private String tokenType;
    
    @JsonProperty("expires_in")
    private String expiresIn;
}
