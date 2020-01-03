package de.stea1th.greetings.web;

import de.stea1th.greetings.entity.Person;
import de.stea1th.greetings.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/api/greetings")
public class PersonController implements PersonOperations {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    public Person get(int id) {
        return personService.get(id);
    }

    public List<Person> getAllByDateOfBirth(LocalDate dateOfBirth) {
        return personService.getAllByDateOfBirth(dateOfBirth);
    }

    public List<Person> getAll() {
        return personService.getAll();
    }
}
