package com.example.jsonschema.validator.domain.builders;

import com.example.jsonschema.validator.domain.models.PersonMusics;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.UUID;

public class PersonMusicsBuilder {

    private UUID musicId;
    private String personName;
    private JsonNode listMusics;

    public static PersonMusicsBuilder create() {
        return new PersonMusicsBuilder();
    }

    public PersonMusicsBuilder withMusicId(UUID musicId) {
        this.musicId = musicId;
        return this;
    }

    public PersonMusicsBuilder withPersonName(String personName) {
        this.personName = personName;
        return this;
    }

    public PersonMusicsBuilder withListMusics(JsonNode listMusics) {
        this.listMusics = listMusics;
        return this;
    }

    public PersonMusics build() {
        return PersonMusics.builder()
                .musicId(musicId)
                .personName(personName)
                .listMusics(listMusics)
                .build();
    }
}