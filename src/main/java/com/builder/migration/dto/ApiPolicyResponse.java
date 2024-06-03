package com.builder.migration.dto;

import java.util.List;

import com.builder.migration.entity.Policy;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiPolicyResponse {
    private int count;
    private List<Policy> list;
}
