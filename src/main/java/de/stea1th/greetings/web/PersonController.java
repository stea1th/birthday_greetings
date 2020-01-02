package de.stea1th.greetings.web;

import de.stea1th.greetings.entity.Person;
import de.stea1th.greetings.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "/api/person")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(value = "/p")
    public Person get(int id) {
        return personService.get(id);
    }

    @GetMapping(value = "/birth")
    public List<Person> getAllByDateOfBirth(LocalDate dateOfBirth) {
        return personService.getAllByDateOfBirth(dateOfBirth);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> getAll() {
        return personService.getAll();
    }
}
