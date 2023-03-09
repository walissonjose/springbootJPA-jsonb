package com.example.jsonschema.validator.services;

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
import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class PersonMusicsService {

    private final PersonMusicsRepository personMusicsRepository;

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
        return null;
    }

    public PersonMusics findOneById(UUID id){
        PersonMusics personMusics = personMusicsRepository.getReferenceById(id);
        return personMusics;
    }

    public List<PersonMusics> findAll(){
        List<PersonMusics> personMusicsList = personMusicsRepository.findAll();
        return personMusicsList;
    }

    public List<PersonMusics> searchByKeyValue(String key, String value) {
        List<PersonMusics> personMusicsList = personMusicsRepository.searchByKeyValue(key, value);
        return personMusicsList;
    }

    public List<PersonMusics> searchByKeyValueInList (String key, String value){
        List<PersonMusics> personMusicsList = personMusicsRepository.searchByKeyValueInList(key, value);
        return personMusicsList;
    }

//    public List<PersonMusics> searchByRegistry(String key, String value){
//        Specification<PersonMusics> specification = (root, query, cb) -> {
//            Path<String> jsonPath = root.get("listMusics"); // obter o caminho para o campo JSON
//            Expression<String> jsonNodeExpression = cb.function("json_extract_path_text", String.class, jsonPath, cb.literal(key)); // criar uma expressão para extrair o valor da chave especificada
//            return cb.equal(jsonNodeExpression, value);
//        };
//        List<PersonMusics> personMusicsList = personMusicsRepository.findAll(specification);
//        return personMusicsList;
//    }

    public PersonMusics addMusic(UUID id, String key, String value) {
//        List<String> formatKeyNode = new LinkedList<>();
//        formatKeyNode.add(key);
        String formatKeyNode = "{"+key+"}";
        String formatValue = value;
        personMusicsRepository.addMusic(id, formatKeyNode, formatValue);
        PersonMusics personMusics = personMusicsRepository.getReferenceById(id);
        return personMusics;
    }

}