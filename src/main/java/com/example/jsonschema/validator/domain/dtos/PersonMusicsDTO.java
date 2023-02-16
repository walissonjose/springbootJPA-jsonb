package com.example.jsonschema.validator.domain.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonMusicsDTO {

    @Schema(description = "Identificador da pessoa")
    private UUID pessoaId;
    @Schema(description = "Nome da pessoa")
    private String name;
    @Schema(description = "Lista de músicas favoritas de um individuo")
    private String listMusic;
}
