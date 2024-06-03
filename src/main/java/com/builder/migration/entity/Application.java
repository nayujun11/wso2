package com.builder.migration.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Application {
    @Id
    private String applicationId;
    private String name;
    private String owner;
    private String status;
    private String groupId;
}
