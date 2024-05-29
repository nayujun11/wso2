package com.builder.migration.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class ApiConverter implements AttributeConverter<ApiDefinition, String> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(ApiDefinition attribute) {
        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error converting to JSON", e);
        }
    }

    @Override
    public ApiDefinition convertToEntityAttribute(String dbData) {
        try {
            return objectMapper.readValue(dbData, ApiDefinition.class);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException("Error converting from JSON", e);
        }
    }
}
