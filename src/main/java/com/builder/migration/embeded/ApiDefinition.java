package com.builder.migration.embeded;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
public class ApiDefinition {
    private String swagger;
    private Map<String, Path> paths;
    private Info info;

    @Data
    public static class Info {
        private String title;
        private String version;
        private String description;
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Path {
        private Get get;

        @Data
        @JsonInclude(JsonInclude.Include.NON_NULL)
        public static class Get {
            private Map<String, Response> responses;

            public Map<String, Response> getResponses() {
                return responses;
            }

            @Data
            @JsonInclude(JsonInclude.Include.NON_NULL)
            public static class Response {
                private String description;
            }
        }
    }
}
