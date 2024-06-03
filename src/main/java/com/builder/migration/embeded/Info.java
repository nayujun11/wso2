package com.builder.migration.embeded;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class Info {
    private String title;
    private String version;
    private String description;
}
