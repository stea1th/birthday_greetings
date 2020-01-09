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

    @Query("SELECT p " +
            "FROM Person p " +
            "WHERE SUBSTRING(CONCAT(p.dateOfBirth, ''), 6, 2) = :birthMonth " +
            "AND SUBSTRING(CONCAT(p.dateOfBirth, ''), 9, 2) = :birthDay ")
    List<Person> findPersonByMonthAndDay(@Param("birthMonth") String birthMonth, @Param("birthDay") String birthDay);

}
