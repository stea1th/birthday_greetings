package de.stea1th.greetings.repository;

import de.stea1th.greetings.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

    private CrudPersonRepository crudPersonRepository;

    @Autowired
    public PersonRepositoryImpl(CrudPersonRepository crudPersonRepository) {
        this.crudPersonRepository = crudPersonRepository;
    }

    @Override
    public Person get(int id) {
        return crudPersonRepository.findById(id).orElse(null);
    }

    @Override
    public List<Person> getAllByDateOfBirth(LocalDate dateOfBirth) {
        return crudPersonRepository.findPersonByDateOfBirth(dateOfBirth);
    }
}
