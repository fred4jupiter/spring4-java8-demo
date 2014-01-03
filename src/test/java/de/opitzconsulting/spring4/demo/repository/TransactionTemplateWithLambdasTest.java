package de.opitzconsulting.spring4.demo.repository;

import de.opitzconsulting.spring4.demo.config.ApplicationConfig;
import de.opitzconsulting.spring4.demo.domain.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class TransactionTemplateWithLambdasTest {

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void useTransactionTemplate() {

        transactionTemplate.execute(new TransactionCallback<Person>() {
            @Override
            public Person doInTransaction(TransactionStatus status) {
                return personRepository.save(new Person("Fred", "Feuerstein"));
            }
        });
    }

    @Test
    public void useTransactionTemplateWithLambda() {
        transactionTemplate.execute((status) -> personRepository.save(new Person("Fred", "Feuerstein")));
    }
}
