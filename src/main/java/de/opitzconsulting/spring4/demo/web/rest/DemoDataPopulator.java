package de.opitzconsulting.spring4.demo.web.rest;

import de.opitzconsulting.spring4.demo.domain.Person;
import de.opitzconsulting.spring4.demo.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;

public class DemoDataPopulator {

    private static final Logger LOG = LoggerFactory.getLogger(DemoDataPopulator.class);

    private final PersonRepository personRepository;

    public DemoDataPopulator(PersonRepository personRepository) {
        this.personRepository = personRepository;
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
