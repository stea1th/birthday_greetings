package de.stea1th.greetings.web;

import de.stea1th.greetings.entity.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@RequestMapping("/default")
public interface PersonOperations {

    @GetMapping(value = "/person")
    Person get(@RequestParam("id") int id);

    @GetMapping(value = "/birth")
    List<Person> getAllByDateOfBirth(LocalDate dateOfBirth);

    @GetMapping(value = "/")
    List<Person> getAll();
}
