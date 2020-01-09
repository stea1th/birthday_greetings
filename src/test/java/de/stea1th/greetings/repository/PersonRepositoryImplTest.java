package de.stea1th.greetings.repository;

import de.stea1th.greetings.entity.Person;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class PersonRepositoryImplTest {

    @Autowired
    private PersonRepository personRepository;

    private Person person;

    @BeforeEach
    void initTest() {
        person = new Person();
        person.setFirstName("Chupa");
        person.setLastName("Pupkin");
        person.setDateOfBirth(LocalDate.now());
        person.setEmail("hallo@web.de");
        person.setAutoEmailGreetings(true);

    }

    @AfterEach
    void cleanTest() {
    }


    @Test
    void get() {
        personRepository.save(person);

        Person current = personRepository.get(1005);

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
