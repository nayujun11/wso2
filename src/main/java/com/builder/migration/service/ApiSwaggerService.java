package com.builder.migration.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.builder.migration.dto.ApiSwaggerResponse;
import com.builder.migration.entity.ApiSwagger;
import com.builder.migration.repository.ApiSwaggerRepository;

@Service
public class ApiSwaggerService {
    
    @Autowired
    private ApiSwaggerRepository apiSwaggerRepository;

    @Autowired
    private ModelMapper modelMapper;

    public void saveApiSwagger(ApiSwaggerResponse  apiSwaggerResponse) {
        ApiSwagger apiSwagger = modelMapper.map(apiSwaggerResponse, ApiSwagger.class);
        apiSwaggerRepository.save(apiSwagger);
    }
}
