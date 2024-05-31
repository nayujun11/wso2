package com.builder.migration.entity;

import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class CorsConfiguration {
    private Boolean corsConfigurationEnabled;
    @ElementCollection
    private List<String> accessControlAllowOrigins;
    private Boolean accessControlAllowCredentials;
    @ElementCollection
    private List<String> accessControlAllowHeaders;
    @ElementCollection
    private List<String> accessControlAllowMethods;
}
