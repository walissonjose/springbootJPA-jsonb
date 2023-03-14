package com.example.jsonschema.validator.repositories;

import com.example.jsonschema.validator.domain.models.PersonMusics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PersonMusicsRepository extends JpaRepository<PersonMusics, UUID> {

    @Query(value = "SELECT * FROM pessoa.musicas " +
                   "WHERE musi_tx_listmusic ->> ?1 ILIKE ?2",
            nativeQuery = true)
    public List<PersonMusics> searchByKeyValue(String key, String value);

    @Query(value = "SELECT * FROM pessoa.musicas \n" +
                   "WHERE musi_tx_listmusic @> CAST(?1 AS jsonb)", nativeQuery = true)
    public List<PersonMusics> searchByKeyValueInList(String query);

//    @Query(value = "UPDATE pessoa.musicas SET musi_tx_listmusic = jsonb_set(musi_tx_listmusic, :key, :value, true) " +
//            "WHERE musi_sq_musicas = :id", nativeQuery = true)
//    public PersonMusics addMusic(@Param("id") UUID id, @Param("key") String key, @Param("value") String value);

}