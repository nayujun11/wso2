package com.builder.migration.entity;

import com.builder.migration.embeded.DefaultLimit;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class Policy {
    @Id
    private String policyId;
    private String policyName;
    private String displayName;
    private String description;
    private boolean isDeployed;

    @Embedded
    private DefaultLimit defaultLimit;
}
