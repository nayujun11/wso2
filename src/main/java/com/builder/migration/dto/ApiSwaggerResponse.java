package com.builder.migration.dto;

import java.util.Map;

import com.builder.migration.embeded.Info;
import com.builder.migration.util.MapToJsonConverter;

import jakarta.persistence.Convert;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiSwaggerResponse {
    private String swagger;
    @Convert(converter = MapToJsonConverter.class)
    private Map<String, Object> paths;
    private Info info;
}
