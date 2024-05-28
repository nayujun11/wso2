package com.builder.migration.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.builder.migration.dto.ApiResponse;
import com.builder.migration.repository.ApiRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.builder.migration.entity.Api;

@Service
public class Wso2ApiService {
    
    @Autowired
    private ApiRepository apiRepository;

    @Value("${api.dockerServer.endpoint.url}")
    private String endPointUrl;

    public void wso2SaveApi() {
        RestTemplate restTemplate = new RestTemplate();
        String jsonResponse = restTemplate.getForObject(endPointUrl, String.class);

        try {
            ObjectMapper mapper = new ObjectMapper();
            ApiResponse apiResponse = mapper.readValue(jsonResponse, ApiResponse.class);
            List<Api> apis = apiResponse.getList().stream().map(api -> {
                Api apiData = new Api();
                apiData.setId(api.getId());
                apiData.setName(api.getName());
                apiData.setDescription(api.getDescription());
                apiData.setContext(api.getContext());
                apiData.setVersion(api.getVersion());
                apiData.setProvider(api.getProvider());
                apiData.setStatus(api.getStatus());
                apiData.setThumbnailUri(api.getThumbnailUri());
                return apiData;
            }).collect(Collectors.toList());

            apiRepository.saveAll(apis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
