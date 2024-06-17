package com.builder.migration.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class KongConsumerResponse {
    private String username;
    private String custom_id; // 외부 시스템 사용자와 구분용 (선택)
}
