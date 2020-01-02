package de.stea1th.greetings;

import de.stea1th.greetings.controller.PersonController;
import de.stea1th.greetings.entity.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.util.List;

public class MainTest {

    public static void main(String[] args) {
        try(ConfigurableApplicationContext context = SpringApplication.run(Application.class, args)) {
            PersonController personController = context.getBean(PersonController.class);
            Person person = personController.get(1000);
            System.out.println(person.getFirstName());
            List<Person> allByDateOfBirth = personController.getAllByDateOfBirth(LocalDate.of(1982, 10, 8));
            allByDateOfBirth.forEach(System.out::println);
        }

    }
}
