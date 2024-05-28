package com.builder.migration.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.builder.migration.dto.ApiResponse;
import com.builder.migration.entity.Api;
import com.builder.migration.service.ApiService;

@RestController
@RequestMapping("/wso2api")
public class ApiController {

    @Autowired
    private ApiService apiService;

    @PostMapping("/add")
    public void addApi(@RequestBody ApiResponse apiResponse) {
        List<Api> apis = apiResponse.getList();
        apiService.saveAll(apis);
    }
}
