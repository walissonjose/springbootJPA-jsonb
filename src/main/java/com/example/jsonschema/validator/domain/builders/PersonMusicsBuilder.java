package com.example.jsonschema.validator.domain.builders;

import com.example.jsonschema.validator.domain.dtos.PersonMusicsDTO;
import com.example.jsonschema.validator.domain.inputs.PersonMusicsInput;
import com.example.jsonschema.validator.domain.models.PersonMusics;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.stereotype.Component;


@Component
public class PersonMusicsBuilder {

    public static PersonMusics buildFromInput(PersonMusicsInput input) {
        ObjectMapper object = new ObjectMapper();
        ArrayNode arrayNode = object.createArrayNode();
        input.getListMusics().forEach(music -> arrayNode.add(music));
        return PersonMusics.builder()
                .personName(input.getPersonName())
                .listMusics(arrayNode)
                .build();
    }

    public static PersonMusicsDTO buildDtoFromModel(PersonMusics personMusics) {
        return PersonMusicsDTO.builder()
                .musicId(personMusics.getMusicId())
                .personName(personMusics.getPersonName())
                .listMusics(personMusics.getListMusics())
                .build();
    }

}