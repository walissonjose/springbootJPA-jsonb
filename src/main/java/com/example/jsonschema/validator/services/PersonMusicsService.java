package com.example.jsonschema.validator.services;

import com.example.jsonschema.validator.domain.dtos.PersonMusicsDTO;
import com.example.jsonschema.validator.domain.models.PersonMusics;
import com.example.jsonschema.validator.repositories.PersonMusicsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PersonMusicsService {

    private final PersonMusicsRepository personMusicsRepository;

    public PersonMusicsService(PersonMusicsRepository personMusicsRepository) {
        this.personMusicsRepository = personMusicsRepository;
    }

    public PersonMusicsDTO updatePersonMusics(UUID musicId, PersonMusicsDTO personMusicsDTO) {
        Optional<PersonMusics> optionalPersonMusics = personMusicsRepository.findById(musicId);
        PersonMusics personMusicsToUpdate = optionalPersonMusics.orElseThrow(() -> new RuntimeException("Music not found"));

        BeanUtils.copyProperties(personMusicsDTO, personMusicsToUpdate);
        personMusicsToUpdate.setMusicId(musicId);
        personMusicsToUpdate = personMusicsRepository.save(personMusicsToUpdate);

        PersonMusicsDTO updatedPersonMusicsDTO = new PersonMusicsDTO();
        BeanUtils.copyProperties(personMusicsToUpdate, updatedPersonMusicsDTO);
        return updatedPersonMusicsDTO;
    }
}