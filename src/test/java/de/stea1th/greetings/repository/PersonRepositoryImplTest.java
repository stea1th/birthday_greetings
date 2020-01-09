package de.stea1th.greetings.repository;

import de.stea1th.greetings.entity.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PersonRepositoryImplTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PersonRepository personRepository;

    private Person person;

    @BeforeEach
    void initTest() {
        person = new Person();
        person.setId(1000);
        person.setFirstName("Vadim");
        person.setLastName("Pupkin");
        person.setDateOfBirth(LocalDate.now());
        person.setEmail("hallo@web.de");
        person.setAutoEmailGreetings(true);
    }

    @AfterEach
    void cleanTest() {
        entityManager.clear();
    }


    @Test
    void get() {
        entityManager.persist(person);
        entityManager.flush();

        Person current = personRepository.get(1000);

        assertEquals(person, current);
    }

    @Test
    void getAllByDateOfBirth() {
    }

    @Test
    void getAll() {
    }

    @Test
    void save() {
    }
}
