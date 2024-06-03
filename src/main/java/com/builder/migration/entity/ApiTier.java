package com.builder.migration.entity;

import java.util.Map;

import com.builder.migration.util.MapToJsonConverter;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ApiTier {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String tierLevel;
    @Convert(converter = MapToJsonConverter.class)
    private Map<String, Object> attributes;
    private int requestCount;
    private int unitTime;
    private String timeUnit;
    private String tierPlan;
    private boolean stopOnQuotaReach;
}
