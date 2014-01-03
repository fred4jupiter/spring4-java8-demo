package de.opitzconsulting.spring4.demo.service;

import de.opitzconsulting.spring4.demo.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class GreetingServiceTest {

    @Autowired
    private GreetingService<GoodMorning> morningService;

    @Autowired
    private GreetingService<GoodEvening> eveningService;

    @Test
    public void checkMorningGreeting() {
        assertThat(morningService.getGreeting().getText(), equalTo("Good Morning"));
    }

    @Test
    public void checkEveningGreeting() {
        assertThat(eveningService.getGreeting().getText(), equalTo("Good Evening"));
    }
}
