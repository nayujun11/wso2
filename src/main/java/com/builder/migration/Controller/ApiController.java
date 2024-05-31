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
import com.builder.migration.entity.CorsConfiguration;
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

    @PostMapping("/apiDetail/add")
    public void addApiDetail(@RequestBody ApiDetailResponse apiDetailResponse) {
        CorsConfiguration corsConfiguration = apiDetailResponse.getCorsConfiguration();
        List<String> headers = corsConfiguration.getAccessControlAllowHeaders();

        for (String header : headers) {
            System.out.println(header);
        }

        apiDetailService.saveApiDetail(apiDetailResponse);
    }
}
