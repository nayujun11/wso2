package com.builder.migration.dto;

import java.util.List;

import com.builder.migration.entity.ApiTier;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiTierResponse {
    private int count;
    private String next;
    private String previous;
    private List<ApiTier> list;
}
