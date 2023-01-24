package test.jsonb.domain.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Id
    private int id;
    private String nome;
    private String interestsJSON; //json as valid json list
    private String additionalInformationJSON; //json as valid json object

    @Convert(converter = HashMapConverter.class)
    private Map<String, Object> additionalInformation;

}
