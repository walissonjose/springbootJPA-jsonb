package test.jsonb.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.jsonb.domain.builders.PersonBuilder;
import test.jsonb.domain.inputs.PersonInput;
import test.jsonb.domain.models.Person;
import test.jsonb.repositories.PersonRepository;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private final PersonRepository personRepository;

    public Person create(PersonInput personInput) {
        Person person = PersonBuilder.build(personInput);
        personRepository.save(person);
        return person;
    }
}
