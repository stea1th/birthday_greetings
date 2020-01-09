package de.stea1th.greetings.web;

import de.stea1th.greetings.entity.Person;
import de.stea1th.greetings.service.PersonService;
import lombok.var;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.Collections;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PersonController.class)
class PersonControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PersonService personService;

    private Person person;

    @BeforeEach
    void initTest() {
        person = new Person();
        person.setId(1000);
        person.setFirstName("Vadim");
        person.setLastName("Pupkin");
        person.setDateOfBirth(LocalDate.now());
        person.setEmail("hallo@web.de");
        person.setAutoEmailGreetings(true);
    }


    @Test
    void get_Id1000_ThenReturnPerson() throws Exception {
        given(personService.get(1000)).willReturn(person);

        mvc.perform((get("/api/greetings/person")
                .param("id", "1000")
                .contentType(MediaType.APPLICATION_JSON)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is(person.getFirstName())));
    }

    @Test
    void getAll_DefaultRequest_ThenReturnJsonArray() throws Exception {

        var allPerson = Collections.singletonList(person);

        given(personService.getAll()).willReturn(allPerson);

        mvc.perform(get("/api/greetings")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].firstName", is(person.getFirstName())));
    }

    @Test
    void toggleEmail() throws Exception {

        mvc.perform(put("/api/greetings/toggle")
                .param("id", "1000")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
