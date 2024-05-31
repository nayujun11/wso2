package com.builder.migration.dto;

import com.builder.migration.entity.Info;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiSwaggerResponse {
    private String swagger;
    private String paths;
    private Info info;
}
