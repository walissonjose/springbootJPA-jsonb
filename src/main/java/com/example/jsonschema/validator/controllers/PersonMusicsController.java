package com.example.jsonschema.validator.controllers;

import com.example.jsonschema.validator.domain.dtos.PersonMusicsDTO;
import com.example.jsonschema.validator.services.PersonMusicsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

@Tag(name = "PersonMusics", description = "Endpoints relacionados a lista de músicas das Pessoas")
@RestController
@RequestMapping("/api/person-musics")
@RequiredArgsConstructor
public class PersonMusicsController {

    private final PersonMusicsService service;
    @PostMapping("/create")
    public ResponseEntity<PersonMusicsDTO> createPersonMusics(@RequestBody PersonMusicsDTO personMusicsDTO, HttpServletRequest request) {
        PersonMusicsDTO createdPersonMusicsDTO = service.createPersonMusics(personMusicsDTO);
        return ResponseEntity.created(URI.create(request.getRequestURI() + "/" + createdPersonMusicsDTO.getMusicId()))
                .body(createdPersonMusicsDTO);
    }
}