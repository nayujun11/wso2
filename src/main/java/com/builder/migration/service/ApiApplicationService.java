package com.builder.migration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.builder.migration.entity.Application;
import com.builder.migration.repository.ApplicationRepository;

@Service
public class ApiApplicationService {
    
    @Autowired
    private ApplicationRepository applicationRepository;

    public void saveAll(List<Application> apis) {
        applicationRepository.saveAll(apis);
    }
}
