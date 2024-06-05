package com.builder.migration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.builder.migration.dto.ApiResponse;
import com.builder.migration.dto.ApiTokenResponse;
import com.builder.migration.repository.ApiRepository;

@Service
public class Wso2GetApisService {
    
    @Autowired
    private ApiRepository apiRepository;

    @Value("${wso2.api.host}")
    private String host;

    @Value("${wso2.api.client_id}")
    private String clientId;

    @Value("${wso2.api.client_secret}")
    private String clientSecret;

    @Value("${wso2.api.username}")
    private String userName;

    @Value("${wso2.api.password}")
    private String passWord;

    @Autowired
    private RestTemplate restTemplate;

    public ApiResponse getWso2Apis(String accessToken) throws Exception {
        String url = host + "/api/am/store/v0.14/apis";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","Bearer " + accessToken);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<ApiResponse> response = restTemplate.exchange(
                url, HttpMethod.GET, entity, ApiResponse.class);

        return response.getBody();
    }
}
