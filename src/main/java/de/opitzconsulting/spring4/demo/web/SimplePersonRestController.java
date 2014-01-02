package de.opitzconsulting.spring4.demo.web;

import de.opitzconsulting.spring4.demo.domain.Person;
import de.opitzconsulting.spring4.demo.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class SimplePersonRestController {

    private static final Logger LOG = LoggerFactory.getLogger(SimplePersonRestController.class);

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "/person/{id}")
    public Person findPersonById(@PathVariable Long id) {
        LOG.debug("findPersonById: id={}", id);
        return personRepository.findOne(id);
    }

    @PostConstruct
    public void populateSomePersonsAtStartup() {
        Person person1 = new Person("Fred", "Feuerstein");
        personRepository.saveAndFlush(person1);
        LOG.info("populating person: {}", person1);

        Person person2 = new Person("Wilma", "Feuerstein");
        personRepository.saveAndFlush(person2);
        LOG.info("populating person: {}", person2);
    }
}
