package com.example.jsonschema.validator.services;

import com.example.jsonschema.validator.domain.builders.PersonMusicsBuilder;
import com.example.jsonschema.validator.domain.dtos.PersonMusicsDTO;
import com.example.jsonschema.validator.domain.models.PersonMusics;
import com.example.jsonschema.validator.repositories.PersonMusicsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}