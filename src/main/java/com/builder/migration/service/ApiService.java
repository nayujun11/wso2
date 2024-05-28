package com.builder.migration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.builder.migration.entity.Api;
import com.builder.migration.repository.ApiRepository;

@Service
public class ApiService {
    
    @Autowired
    private ApiRepository apiRepository;

    public void saveAll(List<Api> apis) {
        apiRepository.saveAll(apis);
    }
}
