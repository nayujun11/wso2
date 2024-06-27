package com.builder.migration.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.builder.migration.dto.KongServiceResponse;
import com.builder.migration.dto.KongUpstreamResponse.ClientCertificate;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KongServiceService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${kong.workspace.id}")
    private String workspaceId;

    @Value("${kong.workspace.name}")
    private String workspaceName;

    @Value("${kong.admin.url}")
    private String adminUrl;

    private List<String> tags;
    private List<String> caCertificates;

    public ResponseEntity<String> createService(KongServiceResponse kongService) throws Exception {

        String url = adminUrl + "/" + workspaceName + "/services";
        // String url = adminUrl +  "/services";

        System.out.println("url:"+url);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        kongService.setName("my-service7");
        kongService.setRetries(5);
        kongService.setProtocol("https");
        kongService.setHost("example.com");
        kongService.setPort(80);
        kongService.setPath("/some_api");
        kongService.setConnectTimeout(6000);
        kongService.setWriteTimeout(6000);
        kongService.setReadTimeout(6000);
        this.tags = new ArrayList<>();
        tags.add("user-level");
        kongService.setTags(tags);

        ClientCertificate clientCertificate = new ClientCertificate();
        // clientCertificate.setId("4e3ad2e4-0bc4-4638-8e34-c84a417ba39b"); // 유효한 uuid셋팅
        // kongService.setCaCertificates(caCertificates);

        // kongService.setTlsVerify(true);
        // kongService.setTlsVerifyDepth(null);
        this.caCertificates = new ArrayList<>();
        // caCertificates.add("4e3ad2e4-0bc4-4638-8e34-c84a417ba39b"); // 유효한 uuid셋팅
        // kongService.setCaCertificates(tags);
        kongService.setEnabled(true);

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String jsonString = objectMapper.writeValueAsString(kongService);
            System.out.println("kongService :" + jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }


        HttpEntity<KongServiceResponse> entity = new HttpEntity<>(kongService, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.POST, entity, String.class);

        return response;
    }

    public ResponseEntity<String> deleteService(String name) throws Exception {

        String url = adminUrl + "/services" + "/" + name;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url, HttpMethod.DELETE, entity, String.class);

        return response;
    }
}
