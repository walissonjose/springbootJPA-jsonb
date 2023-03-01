package com.example.jsonschema.validator.domain.builders;

import com.example.jsonschema.validator.domain.dtos.PersonMusicsDTO;
import com.example.jsonschema.validator.domain.inputs.PersonMusicsInput;
import com.example.jsonschema.validator.domain.models.PersonMusics;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;


@Component
public class PersonMusicsBuilder {

    public static PersonMusics buildFromInput(PersonMusicsInput input) {
        return PersonMusics.builder()
                .personName(input.getPersonName())
                .listMusics(input.getListMusics())
                .build();
    }

    public static PersonMusicsDTO buildDtoFromModel(PersonMusics personMusics) {
        return PersonMusicsDTO.builder()
                .musicId(personMusics.getMusicId())
                .personName(personMusics.getPersonName())
                .listMusics(personMusics.getListMusics())
                .build();
    }

    public static List<PersonMusicsDTO> buildList(List<PersonMusics> personMusicsList){
        List<PersonMusicsDTO> personMusicsDtosList = new LinkedList<>();
        for (PersonMusics personMusics : personMusicsList){
            PersonMusicsDTO personMusicsDTO = buildDtoFromModel(personMusics);
            personMusicsDtosList.add(personMusicsDTO);
        }
        return personMusicsDtosList;
    }

}