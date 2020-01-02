package de.stea1th.greetings.service;

import de.stea1th.greetings.entity.Person;
import de.stea1th.greetings.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person get(int id) {
        return personRepository.get(id);
    }

    @Override
    public List<Person> getAllByDateOfBirth(LocalDate dateOfBirth) {
        return personRepository.getAllByDateOfBirth(dateOfBirth);
    }

    @Override
    public List<Person> getAll() {
        return personRepository.getAll();
    }
}
