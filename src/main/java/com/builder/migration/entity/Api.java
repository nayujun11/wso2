package com.builder.migration.entity;


import java.util.List;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Api {
    @Id
    private String id;
    private String name;
    private String description;
    private String context;
    private String version;
    private String provider;
    private String status;
    private String thumbnailUri;

    // @ElementCollection
    private List<String> scopes;
}
