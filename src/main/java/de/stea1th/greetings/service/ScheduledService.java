package de.stea1th.greetings.service;

import de.stea1th.greetings.entity.Person;
import de.stea1th.greetings.senders.SenderRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@Slf4j
public class ScheduledService {

    private final PersonService personService;

    private final SenderRegistry senderRegistry;

    @Autowired
    public ScheduledService(PersonService personService, SenderRegistry senderRegistry) {
        this.personService = personService;

        this.senderRegistry = senderRegistry;
    }

    //    @Scheduled(cron = "0 0 15 * * ?")
    @Scheduled(fixedRate = 20000)
    public void test() {
        LocalDate localDate = LocalDate.now();
        List<Person> allByDateOfBirth = personService.getAllByDateOfBirth(localDate);

        senderRegistry.getMessageSenders().forEach(sender -> {
            allByDateOfBirth.forEach(person -> {
                sender.sendMessage(person, "Happy birthday!", "\"Happy birthday, dear %s!\"");
            });
        });
//        allByDateOfBirth.forEach(person -> {
////            emailSender.sendMessage(person, "Happy birthday!", String.format("Happy birthday, dear %s!", person.getFirstName()));
////            if (person.isAutoEmailGreetings())
////                log.info("Email gesendet to {} with text: {}", person.getEmail(), ));
//        });
    }

}
