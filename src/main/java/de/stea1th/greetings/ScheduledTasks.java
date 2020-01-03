package de.stea1th.greetings;

import de.stea1th.greetings.entity.Person;
import de.stea1th.greetings.web.PersonOperations;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class ScheduledTasks {

    @Autowired
    private PersonOperations personOperations;

    @Scheduled(fixedRate = 1000)
    public void test() {
        log.info("The time is now {}", LocalDateTime.now());
        Person person = personOperations.get(1000);
        System.out.println(person);
    }

}
