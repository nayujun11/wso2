package com.builder.migration.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.builder.migration.entity.ApiTier;
import com.builder.migration.repository.ApiTierRepository;

@Service
public class ApiTierService {
    
    @Autowired
    private ApiTierRepository apiTierRepository;

    public void saveAll(List<ApiTier> apiTiers) {
        apiTierRepository.saveAll(apiTiers);
    }
}
