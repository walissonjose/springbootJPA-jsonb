package com.example.jsonschema.validator.controllers;

import com.example.jsonschema.validator.configs.ResourceNotFoundException;
import com.example.jsonschema.validator.domain.dtos.PersonMusicsDTO;
import com.example.jsonschema.validator.services.PersonMusicsService;
import com.fasterxml.jackson.databind.JsonNode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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

    @PutMapping("/{id}")
    public ResponseEntity<PersonMusicsDTO> updatePersonMusics(@PathVariable Long id, @RequestBody JsonNode jsonNode) {
        try {
            PersonMusicsDTO updatedPersonMusics = service.updatePersonMusics(String.valueOf(id), jsonNode);
            return ResponseEntity.ok(updatedPersonMusics);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}