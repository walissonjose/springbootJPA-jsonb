package com.example.jsonschema.validator.repositories;

import com.example.jsonschema.validator.domain.models.PersonMusics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PersonMusicsRepository extends JpaRepository<PersonMusics, UUID> {

    @Override
    Optional<PersonMusics> findById(UUID uuid);
}