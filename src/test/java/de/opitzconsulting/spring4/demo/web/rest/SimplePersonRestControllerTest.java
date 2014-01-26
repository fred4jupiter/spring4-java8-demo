package de.opitzconsulting.spring4.demo.web.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.opitzconsulting.spring4.demo.config.WebConfig;
import de.opitzconsulting.spring4.demo.domain.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebConfig.class)
@WebAppConfiguration
public class SimplePersonRestControllerTest {

    @Autowired
    private RestTemplate restTemplate;

    private MockRestServiceServer mockServer;

    @Before
    public void setUp() {
        //create a mock Server instance for RestTemplate
        mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void ping() {
        mockServer.expect(requestTo("/ping")).andExpect(method(HttpMethod.GET)).andRespond(withSuccess("up and running", MediaType.TEXT_PLAIN));
        restTemplate.getForEntity("/ping", String.class);
        mockServer.verify();
    }

    @Test
    public void callRestServiceForPerson() throws JsonProcessingException {
        final Person person = new Person(Long.valueOf(1), "Fred", "Feuerstein");
        String personAsJson = getJsonFromPerson(person);
        mockServer.expect(requestTo("/person/1")).andRespond(withSuccess(personAsJson, MediaType.APPLICATION_JSON));
        ResponseEntity<Person> personEntity = restTemplate.getForEntity("/person/{id}", Person.class, 1);
        mockServer.verify();
        Person returnedPerson = personEntity.getBody();
        assertThat(returnedPerson, equalTo(person));
    }

    private String getJsonFromPerson(Person person) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(person);
    }
}
