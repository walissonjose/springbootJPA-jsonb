package test.jsonb.domain.models;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import test.jsonb.interceptors.CustomInterceptor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HashMapConverter implements AttributeConverter<Map<String, Object>, String> {

    private static final Logger logger = LoggerFactory.getLogger(CustomInterceptor.class);

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Map<String, Object> additionalInformation) {

        String additionalInformationJson = null;
        try {
            additionalInformationJson = objectMapper.writeValueAsString(additionalInformation);
        } catch (final JsonProcessingException e) {
            logger.error("JSON writing error", e);
        }

        return additionalInformationJson;
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String additionalInformationJSON) {

        Map<String, Object> additionalInformation = null;
        try {
            additionalInformation = objectMapper.readValue(additionalInformationJSON, new TypeReference<HashMap<String, Object>>() {});
        } catch (final IOException e) {
            logger.error("JSON reading error", e);
        }

        return additionalInformation;
    }

}