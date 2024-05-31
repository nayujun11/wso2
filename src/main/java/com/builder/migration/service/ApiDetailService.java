package com.builder.migration.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.builder.migration.dto.ApiDetailResponse;
import com.builder.migration.entity.ApiDetail;
import com.builder.migration.repository.ApiDetailRepository;

@Service
public class ApiDetailService {
    
    @Autowired
    private ApiDetailRepository apiDetailRepository;

    @Autowired
    private ModelMapper modelMapper;

    public void saveApiDetail(ApiDetailResponse  apiDetailResponse) {
        ApiDetail apiDetail = modelMapper.map(apiDetailResponse, ApiDetail.class);
        apiDetailRepository.save(apiDetail);
    }
}
