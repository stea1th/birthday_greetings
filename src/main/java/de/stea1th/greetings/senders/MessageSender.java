package de.stea1th.greetings.senders;

import de.stea1th.greetings.entity.Person;
import org.springframework.stereotype.Component;

@Component
public interface MessageSender {

    void sendMessage(Person person, String subject, String text);

}
