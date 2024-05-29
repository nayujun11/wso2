package com.builder.migration.entity;

import java.util.Map;

import lombok.Data;

@Data
public class ApiDefinition {
    private String swagger;
    private Map<String, PathItem> paths;
    private Info info;

    // 기본 생성자 추가
    public ApiDefinition() {}

    @Data
    public static class PathItem {
        private Get get;

        @Data
        public static class Get {
            private Map<String, Response> responses;

            @Data
            public static class Response {
                private String description;
            }
        }
    }

    @Data
    public static class Info {
        private String title;
        private String version;
        private String description;
    }
}