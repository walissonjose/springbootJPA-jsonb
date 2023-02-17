package com.example.jsonschema.validator.domain.inputs;


import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Schema(description = "Representacao de entrada de uma pessoa e sua lista de musicas")
public class PersonMusicsInput {

    @Schema(description = "Nome da pessoa.")
    @NotBlank(message = "The name CANNOT BE EMPTY")
    private String personName;

    @Schema(description = "Lista de musicas preferidas da pessoa.")
    private String listMusics;
}
