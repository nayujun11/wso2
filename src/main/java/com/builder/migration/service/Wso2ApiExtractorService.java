package com.builder.migration.service;
import java.util.Base64;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.builder.migration.repository.ApiRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class Wso2ApiExtractorService {
    
    @Autowired
    private ApiRepository apiRepository;

    @Value("${wso2.api.host}")
    private String host;

    @Value("${wso2.api.client_id}")
    private String clientId;

    @Value("${wso2.api.client_secret}")
    private String clientSecret;

    @Value("${wso2.api.username}")
    private String username;

    @Value("${wso2.api.password}")
    private String password;

    private final ObjectMapper mapper = new ObjectMapper();

        public String getAccessToken() throws Exception {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost post = new HttpPost(host + "/oauth2/token");

            String payload = String.format("grant_type=password&username=%s&password=%s&scope=apim:api_view",
                    username, password);
            post.setEntity(new StringEntity(payload));

            post.setHeader("Authorization", "Basic " + Base64.getEncoder().encodeToString((clientId + ":" + clientSecret).getBytes()));
            post.setHeader("Content-Type", "application/x-www-form-urlencoded");

            HttpResponse response = httpClient.execute(post);
            HttpEntity entity = response.getEntity();
            String responseString = EntityUtils.toString(entity);
            JsonNode responseJson = mapper.readTree(responseString);

            return responseJson.get("access_token").asText();
        }
    }
}
