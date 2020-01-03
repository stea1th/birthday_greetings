package de.stea1th.greetings.components;

import org.springframework.stereotype.Component;

@Component
public interface MessageSender {

    void sendMessage(String to, String subject, String text);

}
