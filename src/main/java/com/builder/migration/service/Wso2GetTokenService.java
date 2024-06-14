package com.builder.migration.service;

import java.util.Base64;

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

@Service
public class Wso2GetTokenService {
    
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


        String originalString = clientId+":"+clientSecret;
        
        // Base64 인코딩
        String encodedString = Base64.getEncoder().encodeToString(originalString.getBytes());
        
        System.out.println("Base64 인코딩 결과: " + encodedString);
        
        String url = host + "/oauth2/token";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/x-www-form-urlencoded");
        headers.set("Authorization","Basic "+encodedString);

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
