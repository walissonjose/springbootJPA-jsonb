package test.jsonb.domain.inputs;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
@Schema(description = "Representacao de entrada de uma nova pessoa.")
public class PersonInput {

    @Schema(description = "Nome da pessoa. Ex: Joao")
    @NotBlank
    private String nome;
    @Schema(description = "Lista de interesses baseada em um Json valido.")
    private String interestsJSON; //json as valid json list
    @Schema(description = "Lista de informacoes adicionais adicionadas como Json valido")
    private String additionalInformationJSON; //json as valid json object
}
