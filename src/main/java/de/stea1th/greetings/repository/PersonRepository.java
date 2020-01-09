package de.stea1th.greetings.repository;

import de.stea1th.greetings.entity.Person;

import java.util.List;

public interface PersonRepository {

    Person get(int id);

    List<Person> getAllByDateOfBirth(String birthMonth, String birthDay);

    List<Person> getAll();

    Person save(Person person);
}
