package com.builder.migration.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class KongPluginAclResponse {
    private String name;
    private Config config;
    private List<String> protocols;
    private Boolean enabled;

    @Data
    @NoArgsConstructor
    public static class Config {
        private List<String> allow;

        @JsonProperty("hide_groups_header")
        private Boolean hideGroupsHeader;
        
        private Integer hour;
        private Integer minute;
        private Integer day;
    }
}
