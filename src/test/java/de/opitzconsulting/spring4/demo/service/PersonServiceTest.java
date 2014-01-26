package de.opitzconsulting.spring4.demo.service;

import de.opitzconsulting.spring4.demo.TransactionalAppConfigDevTest;
import de.opitzconsulting.spring4.demo.domain.Person;
import de.opitzconsulting.spring4.demo.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionalAppConfigDevTest
public class PersonServiceTest {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @Test
    public void findAllPersons() {
        Person personOne = new Person("Fred", "Feuerstein");
        personRepository.saveAndFlush(personOne);
        Person personTwo = new Person("Wilma", "Feuerstein");
        personRepository.saveAndFlush(personTwo);

        List<Person> allPersons = personService.findAllPersons();
        assertThat(allPersons.size(), equalTo(2));
        assertThat(allPersons, hasItems(personOne, personTwo));
    }

}
