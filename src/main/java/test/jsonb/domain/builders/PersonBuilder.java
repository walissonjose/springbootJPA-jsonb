package test.jsonb.domain.builders;

import test.jsonb.domain.dtos.PersonDTO;
import test.jsonb.domain.inputs.PersonInput;
import test.jsonb.domain.models.Person;

public class PersonBuilder {

    public static Person build(PersonInput personInput){
        return Person.builder()
                .nome(personInput.getNome())
                .interestsJSON((personInput.getInterestsJSON()))
                .additionalInformationJSON(personInput.getAdditionalInformationJSON())
                .build();
    }

    public static PersonDTO build(Person person) {
        return PersonDTO.builder()
                .id(person.getId())
                .nome(person.getNome())
                .interestsJSON(person.getInterestsJSON())
                .additionalInformationJSON(person.getAdditionalInformationJSON())
                .build();
    }
}
