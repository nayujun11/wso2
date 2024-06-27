package com.builder.migration.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private List<String> protocols;
    private List<String> methods;
    private List<String> hosts;
    private List<String> paths;
    private List<String> tags;
    private Map<String, List<String>> routeHeaders;

    public ResponseEntity<String> createRoute(KongRouteResponse kongRoute) throws Exception {

        String url = adminUrl + "/routes";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        kongRoute.setName("my-route");
        protocols = new ArrayList<>();
        protocols.add("http");
        protocols.add("https");
        kongRoute.setProtocols(protocols);
        methods = new ArrayList<>();
        methods.add("GET");
        methods.add("POST");
        kongRoute.setMethods(methods);

        routeHeaders = new HashMap<>();
        List<String> myHeaderValues = new ArrayList<>();
        myHeaderValues.add("foo");
        myHeaderValues.add("bar");
        routeHeaders.put("x-my-header", myHeaderValues);

        List<String> anotherHeaderValues = new ArrayList<>();
        anotherHeaderValues.add("bla");
        routeHeaders.put("x-another-header", anotherHeaderValues);
        kongRoute.setHeaders(headers);

        kongRoute.setHttpsRedirectStatusCode(426);
        kongRoute.setRegexPriority(0);
        kongRoute.setStripPath(true);
        kongRoute.setPathHandling("v0");
        kongRoute.setPreserveHost(false);
        kongRoute.setRequestBuffering(true);
        kongRoute.setRequestBuffering(true);

        tags = new ArrayList<>();
        tags.add("user-level");
        tags.add("low-priority");
        kongRoute.setTags(tags);

        KongRouteResponse.Service service = new KongRouteResponse().getService();
        service.setId("af8330d3-dbdc-48bd-b1be-55b98608834b");
        kongRoute.setService(service);

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
