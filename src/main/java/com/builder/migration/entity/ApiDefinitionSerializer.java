package com.builder.migration.entity;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class ApiDefinitionSerializer extends JsonSerializer<ApiDefinition> {
    @Override
    public void serialize(ApiDefinition apiDefinition, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        jsonGenerator.writeString(mapper.writeValueAsString(apiDefinition));
    }
}
