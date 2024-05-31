package com.builder.migration.entity;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Entity
@NoArgsConstructor
@Table(name = "api_detail")
public class ApiDetail {
    @Id
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

    private String endpointSecurity;
    private String gatewayEnvironments;
    private List<String> labels;
    private List<String> sequences;
    private String subscriptionAvailability;
    private List<String> subscriptionAvailableTenants;

    @ElementCollection
    private Map<String, String> additionalProperties;

    private String accessControl;

    @ElementCollection
    private List<String> accessControlRoles;

    private String businessInformation;

    private CorsConfiguration corsConfiguration;
}
