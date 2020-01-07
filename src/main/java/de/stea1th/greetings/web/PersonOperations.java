package de.stea1th.greetings.web;

import de.stea1th.greetings.entity.Person;
import de.stea1th.greetings.xml.PersonTransport;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE })
    List<Person> getAll();

    @PutMapping(value = "/toggle")
    void toggleEmail(@RequestParam("id") int id);
}
