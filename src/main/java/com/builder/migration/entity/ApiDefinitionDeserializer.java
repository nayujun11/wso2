package com.builder.migration.entity;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class ApiDefinitionDeserializer extends JsonDeserializer<ApiDefinition> {
    @Override
    public ApiDefinition deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
        return mapper.readValue(jsonParser, ApiDefinition.class);
    }
}
