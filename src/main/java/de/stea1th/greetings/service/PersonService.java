package de.stea1th.greetings.service;

import de.stea1th.greetings.entity.Person;

import java.time.LocalDate;
import java.util.List;


public interface PersonService {

    Person get(int id);

    List<Person> getAllByDateOfBirth(LocalDate dateOfBirth);
}
