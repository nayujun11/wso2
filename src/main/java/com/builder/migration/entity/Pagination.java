package com.builder.migration.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Pagination {
    private int total;
    private String offset;
    private int limit;
}
