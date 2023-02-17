package com.example.jsonschema.validator.domain.models;

import com.fasterxml.jackson.databind.JsonNode;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.UUID;


@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "PESSOAS", name = "MUSICAS")
@AttributeOverrides({
        @AttributeOverride(name = "musicId", column= @Column(name = "MUSI_SQ_MUSICAS")),
        @AttributeOverride(name = "personName", column = @Column(name = "MUSI_NM_NOME")),
        @AttributeOverride(name = "listMusics", column = @Column(name = "MUSI_TX_LISTMUSIC"))
})
@TypeDef(name = "json", typeClass = JsonType.class)
public class PersonMusics {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(
            name = "uuid2",
            strategy = "uuid2"
    )
    @Column(name = "MUSI_SQ_MUSICAS", nullable = false, updatable = false)
    private UUID musicId;
    @Column(name = "MUSI_NM_NOME", nullable = false)
    private String personName;
    @Type(type = "jsonb")
    @Column(name = "MUSI_TX_LISTMUSIC", columnDefinition = "jsonb", nullable = false)
    private JsonNode listMusics;

}
