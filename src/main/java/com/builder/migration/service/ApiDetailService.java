package com.builder.migration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.builder.migration.entity.ApiDetail;
import com.builder.migration.repository.ApiDetailRepository;

@Service
public class ApiDetailService {
    
    @Autowired
    private ApiDetailRepository apiDetailRepository;

    public void saveAll(List<ApiDetail> apiDetails) {
        // ApiDetail apiDefinition = objectMapper.readValue(json, ApiDetail.class);
        // apiDetailRepository.saveAll((apiDetails));

        if (apiDetails != null) {
            apiDetailRepository.saveAll(apiDetails);
        } else {
            throw new IllegalArgumentException("ApiDetail list must not be null");
        }
    }
}
