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

import com.builder.migration.dto.KongPluginResponse;

@Service
public class KongPluginService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${kong.workspace.id}")
    private String workspaceId;

    @Value("${kong.admin.url}")
    private String adminUrl;

    public ResponseEntity<String> createPlugin(KongPluginResponse kongPlugin) throws Exception {

        String url = adminUrl + "/plugins";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 객체를 사용하여 요청 데이터 생성
        HttpEntity<KongPluginResponse> entity = new HttpEntity<>(kongPlugin, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.POST, entity, String.class);
        return response;
    }

    public ResponseEntity<String> createPluginInService(String id, KongPluginResponse kongPlugin) throws Exception {

        String url = adminUrl + "/services" + "/" + id + "/plugins";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 객체를 사용하여 요청 데이터 생성
        HttpEntity<KongPluginResponse> entity = new HttpEntity<>(kongPlugin, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.POST, entity, String.class);
        return response;
    }

    public ResponseEntity<String> deletePlugin(String id) throws Exception {
        String url = adminUrl + "/plugins" + "/" + id;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 객체를 사용하여 요청 데이터 생성
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.DELETE, entity, String.class);
        return response;
    }

    public ResponseEntity<String> updatePlugin(String id, KongPluginResponse kongPlugin) throws Exception {
        String url = adminUrl + "/plugins" + "/" + id;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 객체를 사용하여 요청 데이터 생성
        HttpEntity<KongPluginResponse> entity = new HttpEntity<>(kongPlugin, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.PATCH, entity, String.class);
        return response;
    }

    // public ResponseEntity<String> deleteKongService(String name) throws Exception {

    //     String url = adminUrl + "/services" + "/" + name;
    //     HttpHeaders headers = new HttpHeaders();
    //     headers.setContentType(MediaType.APPLICATION_JSON);

    //     HttpEntity<String> entity = new HttpEntity<>(headers);

    //     ResponseEntity<String> response = restTemplate.exchange(
    //             url, HttpMethod.DELETE, entity, String.class);

    //     return response;
    // }
}
