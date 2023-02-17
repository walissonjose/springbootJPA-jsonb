package com.example.jsonschema.validator.domain.builders;

import com.example.jsonschema.validator.domain.dtos.PersonMusicsDTO;
import com.example.jsonschema.validator.domain.inputs.PersonMusicsInput;
import com.example.jsonschema.validator.domain.models.PersonMusics;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
public class PersonMusicsBuilder {

    public static PersonMusics buildFromInput(PersonMusicsInput input) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(input.getListMusics());
        return PersonMusics.builder()
                .personName(input.getPersonName())
                .listMusics(jsonNode)
                .build();
    }

    public static PersonMusicsDTO buildDtoFromModel(PersonMusics personMusics) throws IOException {
        return PersonMusicsDTO.builder()
                .musicId(personMusics.getMusicId())
                .personName(personMusics.getPersonName())
                .listMusics(personMusics.getListMusics())
                .build();
    }

}