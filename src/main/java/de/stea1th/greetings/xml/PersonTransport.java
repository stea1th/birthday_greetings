package de.stea1th.greetings.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@JacksonXmlRootElement(localName = "person")
public class PersonTransport {

    @JacksonXmlProperty(localName = "id", isAttribute = true)
    private int id;

    @JacksonXmlProperty(localName = "first-name")
    private String firstName;

    @JacksonXmlProperty(localName = "last-name")
    private String lastName;

    @JacksonXmlProperty(localName = "date-of-birth")
    private LocalDate dateOfBirth;

    @JacksonXmlProperty(localName = "email")
    private String email;

    @JacksonXmlProperty(localName = "auto", isAttribute = true)
    private boolean autoEmailGreetings;
}
