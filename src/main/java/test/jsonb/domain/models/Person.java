package test.jsonb.domain.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {


    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String nome;
    private String interestsJSON; //json as valid json list
    private String additionalInformationJSON; //json as valid json object

    @Convert(converter = HashMapConverter.class)
    private Map<String, Object> additionalInformation;

    private final ObjectMapper objectMapper = new ObjectMapper();
    public void serializePersonAttributes() throws JsonProcessingException {
        this.additionalInformationJSON = objectMapper.writeValueAsString(additionalInformation);

    }
    public void deserializePersonAttributes() throws IOException {
        this.additionalInformation = objectMapper.readValue(additionalInformationJSON, new TypeReference<Map<String, Object>>() {
        });
    }



}
