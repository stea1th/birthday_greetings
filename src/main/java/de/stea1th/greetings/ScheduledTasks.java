package de.stea1th.greetings;

import de.stea1th.greetings.entity.Person;
import de.stea1th.greetings.web.PersonOperations;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Component
@Slf4j
public class ScheduledTasks {

    @Autowired
    private PersonOperations personOperations;

    @Scheduled(fixedRate = 1000)
    public void test() {
        log.info("The time is now {}", LocalDateTime.now());
        LocalDate localDate = LocalDate.of(1985, 10, 8);
        List<Person> allByDateOfBirth = personOperations.getAllByDateOfBirth(localDate);

        allByDateOfBirth.forEach(System.out::println);
    }

}
