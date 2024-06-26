package com.builder.migration.dto;

import java.util.List;

import com.builder.migration.embeded.Pagination;
import com.builder.migration.entity.Api;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiResponse {
    private int count;
    private String next;
    private String previous;
    private List<Api> list;
    private Pagination pagination;
}
