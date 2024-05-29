package com.builder.migration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.builder.migration.dto.ApiDetailResponse;
import com.builder.migration.dto.ApiResponse;
import com.builder.migration.entity.Api;
import com.builder.migration.entity.ApiDetail;
import com.builder.migration.service.ApiDetailService;
import com.builder.migration.service.ApiService;

@RestController
@RequestMapping("/wso2api")
public class ApiController {

    @Autowired
    private ApiService apiService;

    @Autowired
    private ApiDetailService apiDetailService;

    @PostMapping("/api/adds")
    public void addApi(@RequestBody ApiResponse apiResponse) {
        List<Api> apis = apiResponse.getList();
        apiService.saveAll(apis);
    }

    @PostMapping("/apiDetail/adds")
    public void addApiDetail(@RequestBody ApiDetailResponse apiDetailResponse) {
        List<ApiDetail> apiDetails = apiDetailResponse.getList();
        apiDetailService.saveAll(apiDetails);
    }
}
