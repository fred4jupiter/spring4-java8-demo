package de.opitzconsulting.spring4.demo.web;

import de.opitzconsulting.spring4.demo.domain.Person;
import de.opitzconsulting.spring4.demo.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DemoDataPopulator {

    private static final Logger LOG = LoggerFactory.getLogger(DemoDataPopulator.class);

    @Autowired
    private PersonRepository personRepository;

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
