package de.stea1th.greetings.repository;

import de.stea1th.greetings.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Transactional(readOnly = true)
public interface CrudPersonRepository extends JpaRepository<Person, Integer> {

    Optional<Person> findById(Integer id);

    List<Person> findPersonByDateOfBirth(LocalDate dateOfBirth);
}
