package com.builder.migration.dto;

import com.builder.migration.entity.ApiDetail;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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

    private ApiDetail.EndpointConfig endpointConfig;
    private String endpointSecurity;
    private String gatewayEnvironments;
    private List<String> labels;
    private List<String> sequences;

    private String subscriptionAvailability;
    private List<String> subscriptionAvailableTenants;
    private List<ApiDetail> list; // List of ApiDetail objects
}
