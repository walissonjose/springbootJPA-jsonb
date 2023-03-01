package com.example.jsonschema.validator.repositories;

import com.example.jsonschema.validator.domain.models.PersonMusics;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PersonMusicsRepository extends JpaRepository<PersonMusics, UUID> {


    List<PersonMusics> findAll(Specification<PersonMusics> specification);

    @Query(value = "SELECT * FROM pessoa.musicas " +
            "WHERE musi_tx_listmusic ->> ?1 ILIKE ?2",
            nativeQuery = true)
    public List<PersonMusics> searchByKeyValue(String key, String value);


}