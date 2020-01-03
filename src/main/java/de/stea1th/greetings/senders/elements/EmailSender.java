package de.stea1th.greetings.senders.elements;

import de.stea1th.greetings.entity.Person;
import de.stea1th.greetings.senders.MessageSender;
import de.stea1th.greetings.senders.Sender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Sender
public class EmailSender implements MessageSender {

    @Autowired
    private JavaMailSender emailSender;

//    @Autowired
//    public EmailSender(JavaMailSender emailSender) {
//        this.emailSender = emailSender;
//    }

//    @Override
//    public void sendMessage(Person person, String subject, String text) {
//        if (!person.isAutoEmailGreetings()) return;
//        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("noreply.vadim@mail.ru");
//        message.setReplyTo("noreply.vadim@mail.ru");
//        message.setTo(person.getEmail());
//        message.setSubject(subject);
//        message.setText(text);
//
//        emailSender.send(message);
//    }

    @Override
    public void sendMessage(Person person, String subject, String text) {
        if (!person.isAutoEmailGreetings()) return;
        log.info("Email gesendet to: {}", person.getEmail());
        log.info("Subject: {}", subject);
        log.info(String.format(text, person.getFirstName()));
    }

}
