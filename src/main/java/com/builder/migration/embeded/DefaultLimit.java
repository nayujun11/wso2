package com.builder.migration.embeded;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class DefaultLimit {
    private String type;
    private String timeUnit;
    private int unitTime;
    private int requestCount;
}
