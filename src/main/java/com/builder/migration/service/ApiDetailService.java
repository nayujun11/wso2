package com.builder.migration.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.builder.migration.dto.ApiDetailResponse;
import com.builder.migration.entity.ApiDetail;
import com.builder.migration.repository.ApiDetailRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ApiDetailService {
    
    @Autowired
    private ApiDetailRepository apiDetailRepository;

    @Autowired
    private ModelMapper modelMapper;

    public void saveApiDetail(ApiDetailResponse  apiDetailResponse) {
        ApiDetail apiDetail = modelMapper.map(apiDetailResponse, ApiDetail.class);
        apiDetailRepository.save(apiDetail);

        ApiDetail apiDetail2 = apiDetailRepository.findById("3e4fb900-c9bf-4b1a-9b4c-f254167e05e7")
                                             .orElseThrow(() -> new EntityNotFoundException("ApiDetail not found"));
        System.out.println(apiDetail2.getDescription());
    }
}
