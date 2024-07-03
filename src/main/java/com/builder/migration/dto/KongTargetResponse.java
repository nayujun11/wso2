package com.builder.migration.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KongTargetResponse {
    private String name;
    private String algorithm; // round-robin
}
