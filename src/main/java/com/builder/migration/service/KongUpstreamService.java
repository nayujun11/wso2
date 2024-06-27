package com.builder.migration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.builder.migration.dto.KongUpstreamResponse;

@Service
public class KongUpstreamService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${kong.workspace.id}")
    private String workspaceId;

    @Value("${kong.admin.url}")
    private String adminUrl;

    public ResponseEntity<String> createUpstream(KongUpstreamResponse kongUpstream) throws Exception {

        String url = adminUrl + "/upstreams";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // setting 
        kongUpstream.setName("");

        // 객체를 사용하여 요청 데이터 생성
        HttpEntity<KongUpstreamResponse> entity = new HttpEntity<>(kongUpstream, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.POST, entity, String.class);
        return response;
    }
}
