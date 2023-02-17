package com.example.jsonschema.validator.services;

import com.example.jsonschema.validator.configs.ResourceNotFoundException;
import com.example.jsonschema.validator.domain.builders.PersonMusicsBuilder;
import com.example.jsonschema.validator.domain.dtos.PersonMusicsDTO;
import com.example.jsonschema.validator.domain.models.PersonMusics;
import com.example.jsonschema.validator.repositories.PersonMusicsRepository;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class PersonMusicsService {

    private final PersonMusicsRepository personMusicsRepository;
    private final PersonMusicsBuilder personMusicsBuilder;

    public PersonMusicsDTO createPersonMusics(PersonMusicsDTO personMusicsDTO) {
        PersonMusics personMusics = PersonMusics.builder()
                .personName(personMusicsDTO.getPersonName())
                .listMusics(personMusicsDTO.getListMusics())
                .build();
        PersonMusics savedPersonMusics = personMusicsRepository.save(personMusics);
        return PersonMusicsDTO.builder()
                .musicId(savedPersonMusics.getMusicId())
                .personName(savedPersonMusics.getPersonName())
                .listMusics(savedPersonMusics.getListMusics())
                .build();
    }

    public PersonMusicsDTO updatePersonMusics(String id, JsonNode updates) throws IOException {
        PersonMusics personMusics = personMusicsRepository. findById(UUID.fromString(id))
                .orElseThrow(() -> new ResourceNotFoundException("PersonMusics not found for id: " + id));

        // Update PersonMusics with new values
        if (updates.has("musicId")) {
            personMusics.setMusicId(UUID.fromString(updates.get("musicId").asText()));
        }
        if (updates.has("personName")) {
            personMusics.setPersonName(updates.get("personName").asText());
        }
        if (updates.has("listMusics")) {
            personMusics.setListMusics(updates.get("listMusics"));
        }

        // Save updated PersonMusics to the database
        PersonMusics updatedPersonMusics = personMusicsRepository.save(personMusics);

        // Convert updated PersonMusics to DTO and return
        return personMusicsBuilder.buildDtoFromModel(updatedPersonMusics);
    }

}