package com.builder.migration.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.builder.migration.embeded.ApiDefinition;
import com.builder.migration.entity.ApiDetail;
import com.builder.migration.repository.ApiDetailRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ApiDefinitionService {
    @Autowired
    private ApiDetailRepository apiDetailRepository;

    @Autowired
    private ObjectMapper objectMapper;

    public ApiDefinition getApiDefinition(String id) throws IOException {
        Optional<ApiDetail> apiDetailOptional = apiDetailRepository.findById(id);
        if (apiDetailOptional.isPresent()) {
            ApiDetail apiDetail = apiDetailOptional.get();
            String apiDefinitionJson = apiDetail.getApiDefinition();
            return objectMapper.readValue(apiDefinitionJson, ApiDefinition.class);
        } else {
            throw new RuntimeException("No ApiDetail found for id " + id);
        }
    }
}
