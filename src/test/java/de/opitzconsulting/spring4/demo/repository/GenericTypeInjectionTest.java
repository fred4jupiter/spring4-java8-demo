package de.opitzconsulting.spring4.demo.repository;

import de.opitzconsulting.spring4.demo.config.AppConfig;
import de.opitzconsulting.spring4.demo.domain.Customer;
import de.opitzconsulting.spring4.demo.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class GenericTypeInjectionTest {

    private static final Logger LOG = LoggerFactory.getLogger(GenericTypeInjectionTest.class);

    @Autowired
    private JpaRepository<Customer, Long> customerRepository;

    @Autowired
    private JpaRepository<Person, Long> personRepository;

    @Test
    public void saveAndFindCustomer() {
        Customer customer = customerRepository.saveAndFlush(new Customer("Fred"));
        LOG.debug("saveAndFindCustomer: customer={}", customer);
        Customer foundCustomer = customerRepository.findOne(customer.getId());
        assertThat(foundCustomer, equalTo(customer));
    }

    @Test
    public void saveAndFindPerson() {
        Person person = personRepository.saveAndFlush(new Person("Fred", "Feuerstein"));
        LOG.debug("saveAndFindPerson: person={}", person);
        Person foundPerson = personRepository.findOne(person.getId());
        assertThat(foundPerson, equalTo(person));
    }
}
