package de.opitzconsulting.spring4.demo.repository;

import de.opitzconsulting.spring4.demo.config.AppConfig;
import de.opitzconsulting.spring4.demo.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class CustomerRepositoryTest {

    private static final Logger LOG = LoggerFactory.getLogger(CustomerRepositoryTest.class);

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void findCustomer() {
        Customer customer = customerRepository.saveAndFlush(new Customer("Fred"));
        LOG.debug("findCustomer: customer={}", customer);
        Customer foundCustomer = customerRepository.findOne(customer.getId());
        assertThat(foundCustomer, equalTo(customer));
    }
}
