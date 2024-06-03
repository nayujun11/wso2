package com.builder.migration.dto;

import java.util.List;

import com.builder.migration.entity.Application;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiApplicationResponse {
    private int count;
    private String next;
    private String previous;
    private List<Application> list;
}
