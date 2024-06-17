package com.builder.migration.dto;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class KongPluginResponse {
    private String name;
    private String route;
    private String service;
    private String consumer;
    private String instance_name;
    private Config config;
    private List<String> protocols;
    private Boolean enabled;
    private List<String> tags;
    private Ordering ordering; //cousumer 적용된 호출에서는 ordering 적용불가

    @Data
    @NoArgsConstructor
    public static class Config {
        private Integer hour;
        private Integer minute;
        private Integer day;
        //{"day": null, "hour": 50, "path": null, "year": null, "month": null, "redis": {"ssl": false, "host": null, "port": 6379,
        //"timeout": 2000, "database": 0, "password": null, "username": null, "ssl_verify": false, "server_name": null}, "minute": 50, 
        //"policy": "local", "second": null, "limit_by": "consumer", "sync_rate": -1, "error_code": 429, 
        //"header_name": null, "error_message": "API rate limit exceeded", "fault_tolerant": true, "hide_client_headers": false}
    }

    @Data
    @NoArgsConstructor
    public static class Ordering {
        private List<String> before;
    }
}