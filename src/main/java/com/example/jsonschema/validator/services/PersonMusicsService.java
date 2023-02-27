package com.example.jsonschema.validator.services;

import com.example.jsonschema.validator.configs.ResourceNotFoundException;
import com.example.jsonschema.validator.domain.builders.PersonMusicsBuilder;
import com.example.jsonschema.validator.domain.dtos.PersonMusicsDTO;
import com.example.jsonschema.validator.domain.inputs.PersonMusicsInput;
import com.example.jsonschema.validator.domain.models.PersonMusics;
import com.example.jsonschema.validator.repositories.PersonMusicsRepository;
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

    public PersonMusicsDTO createPersonMusics(PersonMusicsInput personMusicsInput) {
        PersonMusics personMusics = PersonMusicsBuilder.buildFromInput(personMusicsInput);
        PersonMusics savedPersonMusics = personMusicsRepository.save(personMusics);
        return PersonMusicsDTO.builder()
                .musicId(savedPersonMusics.getMusicId())
                .personName(savedPersonMusics.getPersonName())
                .listMusics(savedPersonMusics.getListMusics())
                .build();
    }

    public PersonMusicsDTO updatePersonMusics(String id, PersonMusicsInput updates) throws IOException {
        PersonMusics personMusics = personMusicsRepository. findById(UUID.fromString(id))
                .orElseThrow(() -> new ResourceNotFoundException("PersonMusics not found for id: " + id));

        // Save updated PersonMusics to the database
        PersonMusics updatedPersonMusics = personMusicsRepository.save(personMusics);

        // Convert updated PersonMusics to DTO and return
        return personMusicsBuilder.buildDtoFromModel(updatedPersonMusics);
    }

}