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
import com.builder.migration.dto.KongRouteResponse;

@Service
public class KongRouteService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${kong.workspace.id}")
    private String workspaceId;

    @Value("${kong.admin.url}")
    private String adminUrl;

    public ResponseEntity<String> createKongRoute(KongRouteResponse kongRoute) throws Exception {

        String url = adminUrl + "/routes";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<KongRouteResponse> entity = new HttpEntity<>(kongRoute, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.POST, entity, String.class);

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
