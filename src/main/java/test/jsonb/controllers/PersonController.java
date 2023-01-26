package test.jsonb.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.jsonb.domain.builders.PersonBuilder;
import test.jsonb.domain.dtos.PersonDTO;
import test.jsonb.domain.inputs.PersonInput;
import test.jsonb.domain.models.Person;
import test.jsonb.services.PersonService;

@Tag(name = "Persons", description = "Endpoints of Person")
@RestController
@RequestMapping("/person")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private final PersonService service;
    @Operation(
            summary = "Create new Person",
            description = "based on request structure, add new person to Postgresql database"
    )
    @PostMapping("/")
    public PersonDTO create(@Valid @RequestBody PersonInput personInput) {
        Person person = service.create(personInput);
        return PersonBuilder.build(person);
    }

}
