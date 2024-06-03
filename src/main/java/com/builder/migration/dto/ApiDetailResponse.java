package com.builder.migration.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.builder.migration.embeded.CorsConfiguration;

import jakarta.persistence.Embedded;

@Data
@NoArgsConstructor
public class ApiDetailResponse {
    private String id;
    private String name;
    private String description;
    private String context;
    private String version;
    private String provider;
    private String status;
    private String thumbnailUri;
    private String apiDefinition;
    private String wsdlUri;
    private String responseCaching;
    private int cacheTimeout;
    private Boolean destinationStatsEnabled;
    private Boolean isDefaultVersion;
    private String type;

    private List<String> transport;
    private List<String> tags;
    private List<String> tiers;

    private String apiLevelPolicy;
    private String authorizationHeader;
    private String maxTps;
    private String visibility;
    private List<String> visibleRoles;
    private List<String> visibleTenants;
    private String endpointConfig;
    private String endpointSecurity;
    private String gatewayEnvironments;
    private List<String> labels;
    private List<String> sequences;

    @Embedded
    private CorsConfiguration corsConfiguration;

    private String subscriptionAvailability;
    private List<String> subscriptionAvailableTenants;

}
