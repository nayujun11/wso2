package com.builder.migration.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class KongConsumerResponse {
    private String username;
    
    @JsonProperty("custom_id")
    private String customId; // 외부 시스템 사용자와 구분용 (선택)
}
