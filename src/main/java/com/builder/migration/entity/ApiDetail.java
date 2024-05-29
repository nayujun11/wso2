package com.builder.migration.entity;

import jakarta.persistence.Convert;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Data
@Entity
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
    // private String apiDefinition;
    @JsonDeserialize(using = ApiDefinitionDeserializer.class)
    @JsonSerialize(using = ApiDefinitionSerializer.class)
    @Convert(converter = ApiConverter.class)
    private ApiDefinition apiDefinition;

    private String wsdlUri;
    private String responseCaching;
    private int cacheTimeout;
    private Boolean destinationStatsEnabled;
    private Boolean isDefaultVersion;
    private String type;

    @ElementCollection
    private List<String> transport;

    @ElementCollection
    private List<String> tags;

    @ElementCollection
    private List<String> tiers;

    private String apiLevelPolicy;
    private String authorizationHeader;
    private String maxTps;
    private String visibility;

    @ElementCollection
    private List<String> visibleRoles;

    @ElementCollection
    private List<String> visibleTenants;

    private EndpointConfig endpointConfig;
    private String endpointSecurity;
    private String gatewayEnvironments;

    @ElementCollection
    private List<String> labels;

    @ElementCollection
    private List<String> sequences;

    private String subscriptionAvailability;

    @ElementCollection
    private List<String> subscriptionAvailableTenants;

    @ElementCollection
    private Map<String, String> additionalProperties;

    private String accessControl;

    @ElementCollection
    private List<String> accessControlRoles;

    @Embedded
    private BusinessInformation businessInformation;

    @Embedded
    private CorsConfiguration corsConfiguration;

    @Data
    @Embeddable
    public static class EndpointConfig {
        private ProductionEndpoints productionEndpoints;
        private String endpointType;

        @Data
        @Embeddable
        public static class ProductionEndpoints {
            private String url;
            private String config;
            private boolean templateNotSupported;
        }
    }

    @Data
    @Embeddable
    public static class BusinessInformation {
        private String businessOwner;
        private String businessOwnerEmail;
        private String technicalOwner;
        private String technicalOwnerEmail;
    }

    @Data
    @Embeddable
    public static class CorsConfiguration {
        private boolean corsConfigurationEnabled;
        private List<String> accessControlAllowOrigins;
        private boolean accessControlAllowCredentials;
        private List<String> accessControlAllowHeaders;
        private List<String> accessControlAllowMethods;
    }
}
