package com.example.jsonschema.validator.configs;

import com.example.jsonschema.validator.validator.Validator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class AppConfig {

    @Bean
    public Validator validator(ObjectMapper objectMapper) throws ProcessingException, IOException {
        return new Validator(objectMapper);
    }
}
