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
    private String algorithm;
    @JsonProperty("hash_on")
    private String hashOn;
    @JsonProperty("hash_fallback")
    private String hashFallback;
    @JsonProperty("hash_on_cookie_path")
    private String hashOnCookiePath;
    private int slots;
    private Healthchecks healthchecks;
    private List<String> tags;
    @JsonProperty("host_header")
    private String hostHeader;
    @JsonProperty("client_certificate")
    private ClientCertificate clientCertificate;
    @JsonProperty("use_srv_name")
    private boolean useSrvName;

    @Data
    @NoArgsConstructor
    public static class Healthchecks {
        private Passive passive;
        private Active active;
        private int threshold;

        @Data
        @NoArgsConstructor
        public static class Passive {
            private String type;
            private Healthy healthy;
            private Unhealthy unhealthy;

            @Data
            @NoArgsConstructor
            public static class Healthy {
                @JsonProperty("http_statuses")
                private List<Integer> httpStatuses;
                private int successes;
            }

            @Data
            @NoArgsConstructor
            public static class Unhealthy {
                @JsonProperty("http_statuses")
                private List<Integer> httpStatuses;
                private int timeouts;
                @JsonProperty("http_failures")
                private int httpFailures;
                @JsonProperty("tcp_failures")
                private int tcpFailures;
            }
        }

        @Data
        @NoArgsConstructor
        public static class Active {
            @JsonProperty("https_verify_certificate")
            private boolean httpsVerifyCertificate;
            private com.builder.migration.dto.KongUpstreamResponse.Healthchecks.Passive.Healthy healthy;
            private com.builder.migration.dto.KongUpstreamResponse.Healthchecks.Passive.Unhealthy unhealthy;
            private String type;
            private int concurrency;
            private Headers headers;
            private int timeout;

            @JsonProperty("http_path")
            private String httpPath;

            @JsonProperty("https_sni")
            private String httpsSni;

            @Data
            @NoArgsConstructor
            public static class Headers {
                @JsonProperty("x-my-header")
                private List<Header> xMyHeader;
                
                @JsonProperty("x-another-header")
                private List<Header> xAnotherHeader;

                @Data
                @NoArgsConstructor
                public static class Header {
                    private String type;
                    private String description;
                }
            }
        }
    }

    @Data
    @NoArgsConstructor
    public static class ClientCertificate {
        private String id;
    }
}