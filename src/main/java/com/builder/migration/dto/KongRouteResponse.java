package com.builder.migration.dto;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class KongRouteResponse {
    private String name;
    private List<String> protocols;
    private List<String> methods;
    private List<String> hosts;
    private List<String> paths;
    private Map<String, List<String>> headers;
    
    @JsonProperty("https_redirect_status_code")
    private Integer httpsRedirectStatusCode;

    @JsonProperty("regex_priority")
    private Integer regexPriority;

    @JsonProperty("strip_path")
    private Boolean stripPath;

    @JsonProperty("path_handling")
    private String pathHandling;

    @JsonProperty("preserve_host")
    private Boolean preserveHost;

    @JsonProperty("request_buffering")
    private Boolean requestBuffering;

    @JsonProperty("response_buffering")
    private Boolean responseBuffering;

    private List<String> tags;
    private Service service;

    @Data
    @NoArgsConstructor
    public static class Service {
        private String id;
    }
}
