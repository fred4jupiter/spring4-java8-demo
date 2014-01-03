package de.opitzconsulting.spring4.demo.web;

import de.opitzconsulting.spring4.demo.domain.Person;
import de.opitzconsulting.spring4.demo.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimplePersonRestController {

    private static final Logger LOG = LoggerFactory.getLogger(SimplePersonRestController.class);

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public String ping() {
        return "up and running";
    }

    @RequestMapping(value = "/person/{id}")
    public Person findPersonById(@PathVariable Long id) {
        LOG.debug("findPersonById: id={}", id);
        return personRepository.findOne(id);
    }

}
