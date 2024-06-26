package com.builder.migration.entity;

import java.util.Map;

import com.builder.migration.embeded.Info;
import com.builder.migration.util.MapToJsonConverter;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class ApiSwagger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String swaggerVersion;
    
    @Convert(converter = MapToJsonConverter.class)
    private Map<String, Object> paths;
    private Info info;
}
