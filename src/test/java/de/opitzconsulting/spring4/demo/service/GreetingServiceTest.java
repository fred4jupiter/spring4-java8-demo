package de.opitzconsulting.spring4.demo.service;

import de.opitzconsulting.spring4.demo.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.util.MatcherAssertionErrors.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public class GreetingServiceTest {

    @Autowired
    private GreetingService<GoodMorning> goodMorningService;

    @Autowired
    private GreetingService<GoodEvening> goodEveningService;

    @Test
    public void checkMorningGreeting() {
        assertThat(goodMorningService.getGreeting().getText(), equalTo("Good Morning"));
    }

    @Test
    public void checkEveningGreeting() {
        assertThat(goodEveningService.getGreeting().getText(), equalTo("Good Evening"));
    }
}
