package test.jsonb.domain.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {
    @Schema(description = "ID of person")
    private UUID id;
    @Schema(description = "Name of person")
    private String nome;
    @Schema(description = "List of interests")
    private String interestsJSON;
    @Schema(description = "additional information about this person")
    private String additionalInformationJSON;
}
