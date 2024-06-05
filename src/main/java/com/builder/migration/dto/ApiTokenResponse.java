package com.builder.migration.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiTokenResponse {
    private String access_token;
    private String refresh_token;
    private String scope;
    private String token_type;
    private String expires_in;
}
