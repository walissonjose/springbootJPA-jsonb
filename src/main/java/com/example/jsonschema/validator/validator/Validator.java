package com.example.jsonschema.validator.validator;


import com.example.jsonschema.validator.domain.inputs.PersonMusicsInput;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchema;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class Validator {

    private final ObjectMapper objectMapper;
    private final JsonSchema schema;

    public Validator(ObjectMapper objectMapper) throws ProcessingException, IOException {
        this.objectMapper = objectMapper;
        this.schema = loadSchema();
    }

    public void validate(PersonMusicsInput personMusicsInput) throws ProcessingException {
        JsonNode inputJsonNode = objectMapper.valueToTree(personMusicsInput);
        ProcessingReport processingReport = schema.validate(inputJsonNode);
        if(!processingReport.isSuccess()) {
            String errorMessage = processingReport.toString();
            throw new IllegalArgumentException("Invalid Input: " + errorMessage);
        }
    }

    private JsonSchema loadSchema() throws ProcessingException, IOException {
        JsonNode schemaJsonNode = objectMapper.readTree(new ClassPathResource("/schema/musics-schema.json").getFile());
        JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.byDefault();
        return jsonSchemaFactory.getJsonSchema(schemaJsonNode);
    }
}
