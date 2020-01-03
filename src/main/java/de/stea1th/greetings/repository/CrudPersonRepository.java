package de.stea1th.greetings.repository;

import de.stea1th.greetings.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Transactional(readOnly = true)
public interface CrudPersonRepository extends JpaRepository<Person, Integer> {

    Optional<Person> findById(Integer id);


    @Query(value = "select * from person\n" +
            "where date_part('day', date_of_birth) = :birthDay and date_part('month', date_of_birth) = :birthMonth", nativeQuery = true)
    List<Person> findPersonByDateOfBirth(@Param("birthMonth") int birthMonth, @Param("birthDay") int birthDay);


}
