package de.stea1th.greetings.web;

import de.stea1th.greetings.entity.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("/default")
public interface PersonOperations {

    @GetMapping(value = "/person")
    Person get(@RequestParam("id") int id);

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE, MediaType.TEXT_XML_VALUE })
    List<Person> getAll();

    @PutMapping(value = "/toggle")
    void toggleEmail(@RequestParam("id") int id);
}
