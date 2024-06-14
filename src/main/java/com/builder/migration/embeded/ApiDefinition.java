package com.builder.migration.embeded;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ApiDefinition {

    @JsonProperty("swagger")
    private String swagger;

    @JsonProperty("paths")
    private Map<String, Path> paths;

    @JsonProperty("info")
    private Info info;

    @Data
    public static class Info {
        @JsonProperty("title")
        private String title;

        @JsonProperty("version")
        private String version;

        @JsonProperty("description")
        private String description;
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Path {
        @JsonProperty("get")
        private Get get;

        @Data
        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class Get {
            @JsonProperty("responses")
            private Map<String, Response> responses;

            public Map<String, Response> getResponses() {
                return responses;
            }

            @Data
            @JsonInclude(JsonInclude.Include.NON_NULL)
            public static class Response {
                @JsonProperty("description")
                private String description;
            }
        }
    }
}
