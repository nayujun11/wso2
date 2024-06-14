package com.builder.migration.dto;

import java.util.List;
import java.util.Map;

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
    private Integer https_redirect_status_code;
    private Integer regex_priority;
    private Boolean strip_path;
    private String path_handling;
    private Boolean preserve_host;
    private Boolean request_buffering;
    private Boolean response_buffering;
    private List<String> tags;
    private Service service;

    @Data
    @NoArgsConstructor
    public static class Service {
        private String id;
    }
}
