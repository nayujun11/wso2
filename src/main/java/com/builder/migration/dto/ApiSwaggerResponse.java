package com.builder.migration.dto;

import java.util.List;

import com.builder.migration.entity.Info;

import jakarta.persistence.Embedded;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiSwaggerResponse {
    private String swagger;
    private List<String> paths;
    @Embedded
    private Info info;
}
