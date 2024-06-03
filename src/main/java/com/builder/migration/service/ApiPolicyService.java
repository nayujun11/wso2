package com.builder.migration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.builder.migration.entity.Policy;
import com.builder.migration.repository.ApiPolicyRepository;

@Service
public class ApiPolicyService {
    
    @Autowired
    private ApiPolicyRepository apiPolicyRepository;

    public void saveAll(List<Policy> policies) {
        apiPolicyRepository.saveAll(policies);
    }
}
