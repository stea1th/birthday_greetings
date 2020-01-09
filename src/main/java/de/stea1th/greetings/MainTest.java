package de.stea1th.greetings;

import de.stea1th.greetings.entity.Person;
import de.stea1th.greetings.web.PersonController;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class MainTest {

    public static void main(String[] args) {
        try(ConfigurableApplicationContext context = SpringApplication.run(Application.class, args)) {
            PersonController personController = context.getBean(PersonController.class);
            Person person = personController.get(1000);
            System.out.println(person.getFirstName());
        }

    }
}
