package com.builder.migration.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KongUpstreamResponse {
    private String name;
    private String algorithm; // round-robin

    @JsonProperty("hash_on")
    private String hashOn; // none

    @JsonProperty("hash_fallback")
    private String hashFallback; // none

    @JsonProperty("hash_on_cookie_path")
    private String hashOnCookiePath; // "/"

    private int slots; // 10000
    private Healthchecks healthchecks;
    private List<String> tags; // "user-level", "low-priority"

    @JsonProperty("host_header")
    private String hostHeader; // example.com

    private ClientCertificate clientCertificate;

    @JsonProperty("use_srv_name")
    private boolean useSrvName; // false

    @Data
    @NoArgsConstructor
    public static class Healthchecks {
        private Passive passive;
        private Active active;
        private int threshold;
    }

    @Data
    @NoArgsConstructor
    public static class Passive {
        private String type; // http
        private Healthy healthy;
        private Unhealthy unhealthy;
    }

    @Data
    @NoArgsConstructor
    public static class Healthy {
        @JsonProperty("http_statuses")
        private List<Integer> httpStatuses; //200,201,202,203,204,205,206,207,208,226,300,301,302,303,304,305,306,307,308

        private int successes; // 0
    }

    @Data
    @NoArgsConstructor
    public static class Unhealthy {
        @JsonProperty("http_statuses")
        private List<Integer> httpStatuses; // 429,500,503

        private int timeouts; // 0

        @JsonProperty("http_failures")
        private int httpFailures; // 0

        @JsonProperty("tcp_failures")
        private int tcpFailures; // 0
    }

    @Data
    @NoArgsConstructor
    public static class Active {
        @JsonProperty("https_verify_certificate")
        private boolean httpsVerifyCertificate; // true

        private Healthy healthy;
        private Unhealthy unhealthy;
        private String type; // http
        private int concurrency; // 10
        private Headers headers; 
        private int timeout; // 1

        @JsonProperty("http_path")
        private String httpPath; // "/"

        @JsonProperty("https_sni")
        private String httpsSni; // "example.com"
    }

    @Data
    @NoArgsConstructor
    public static class Headers {
        @JsonProperty("x-my-header")
        private List<Header> xMyHeader;

        @JsonProperty("x-another-header")
        private List<Header> xAnotherHeader;
    }

    @Data
    @NoArgsConstructor
    public static class Header {
        private String type; // array
        private List<String> items; // string
        private String description; // The value(s) of the x-my-header header.
    }

    @Data
    @NoArgsConstructor
    public static class ClientCertificate {
        private String id; // ea29aaa3-3b2d-488c-b90c-56df8e0dd8c6
    }
}