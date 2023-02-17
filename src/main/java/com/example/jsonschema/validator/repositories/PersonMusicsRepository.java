package com.example.jsonschema.validator.repositories;

import com.example.jsonschema.validator.domain.models.PersonMusics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonMusicsRepository extends JpaRepository<PersonMusics, UUID> {

}