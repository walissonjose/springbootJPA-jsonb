package com.example.jsonschema.validator.controllers;

import com.example.jsonschema.validator.services.PersonMusicsService;
import com.example.jsonschema.validator.domain.dtos.PersonMusicsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/person-musics")
@RequiredArgsConstructor
public class PersonMusicsController {

    private final PersonMusicsService service;

    @PutMapping("/{musicId}")
    @ResponseStatus(HttpStatus.OK)
    public PersonMusicsDTO updatePersonMusics(@PathVariable UUID musicId, @RequestBody PersonMusicsDTO personMusicsDTO) {
        return service.updatePersonMusics(musicId, personMusicsDTO);
    }
}