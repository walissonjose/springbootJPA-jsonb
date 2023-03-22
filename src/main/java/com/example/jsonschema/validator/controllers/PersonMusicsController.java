package com.example.jsonschema.validator.controllers;

import com.example.jsonschema.validator.domain.builders.PersonMusicsBuilder;
import com.example.jsonschema.validator.domain.dtos.PersonMusicsDTO;
import com.example.jsonschema.validator.domain.inputs.PersonMusicsInput;
import com.example.jsonschema.validator.services.PersonMusicsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@Tag(name = "PersonMusics", description = "Endpoints relacionados a lista de músicas das Pessoas")
@RestController
@RequestMapping("/api/person-musics")
@RequiredArgsConstructor
@Validated
public class PersonMusicsController {

    private final PersonMusicsService service;
    @PostMapping("/create")
    public ResponseEntity<PersonMusicsDTO> createPersonMusics(@RequestBody @Valid PersonMusicsInput personMusicsInput, HttpServletRequest request) {
        PersonMusicsDTO createdPersonMusicsDTO = service.createPersonMusics(personMusicsInput);
        return ResponseEntity.created(URI.create(request.getRequestURI() + "/" + createdPersonMusicsDTO.getMusicId()))
                .body(createdPersonMusicsDTO);
    }

    @GetMapping("/find/one/{id}")
    public ResponseEntity<PersonMusicsDTO> findOneById(@PathVariable UUID id) {
        return ResponseEntity.ok(PersonMusicsBuilder.buildDtoFromModel(service.findOneById(id)));
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<PersonMusicsDTO>> findAll(){
        return ResponseEntity.ok(PersonMusicsBuilder.buildList(service.findAll()));
    }

    @GetMapping("search/json/{key}/{value}")
    public ResponseEntity<List<PersonMusicsDTO>> searchJsonByKeyValue(@PathVariable String key, @PathVariable String value){
        return ResponseEntity.ok(PersonMusicsBuilder.buildList(service.searchByKeyValue(key, value)));
    }

    @GetMapping("search/json")
    public ResponseEntity<List<PersonMusicsDTO>> searchJsonByKeyValue(@RequestParam String query) {
        return ResponseEntity.ok(PersonMusicsBuilder.buildList(service.searchByKeyValueInList(query)));
    }

}