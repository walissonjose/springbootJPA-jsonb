package com.example.jsonschema.validator.configs;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;

import java.io.IOException;

public class ValidationConfig {
    private static final String SCHEMA_PATH = "..\\resources\\schema";
    private JsonSchema schema;

    public ValidationConfig() throws IOException, ProcessingException {
        JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
        this.schema = factory.getJsonSchema(String.valueOf(getClass().getResource(SCHEMA_PATH)));
    }

    public boolean validate(JsonNode input) throws ProcessingException {
        return schema.validate(input).isSuccess();
    }

}
