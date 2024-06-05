package com.builder.migration.service;

import org.apache.tomcat.util.http.parser.Authorization;
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

import com.builder.migration.dto.ApiTokenResponse;
import com.builder.migration.repository.ApiRepository;

@Service
public class Wso2GetTokenService {
    
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

    public ApiTokenResponse getAccessToken() throws Exception {
        
        String url = host + "/oauth2/token";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/x-www-form-urlencoded");
        headers.set("Authorization","Basic OXo0b29NSDRVOUJKM2VSV0ROZzB3bVUybnNvYTp3d1RuTXh4MzRUS3RsZ01wTms5ZmFKX1JiWllh");

        MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
        requestBody.add("username", userName);
        requestBody.add("password", passWord);
        requestBody.add("grant_type", "password");
        requestBody.add("scope", "apim:api_view");

        HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(requestBody, headers);
        ResponseEntity<ApiTokenResponse> response = restTemplate.exchange(
                url, HttpMethod.POST, entity, ApiTokenResponse.class);
        return response.getBody();
    }
}
