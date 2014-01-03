package de.opitzconsulting.spring4.demo.service;

import de.opitzconsulting.spring4.demo.config.ApplicationConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfig.class)
public class ConditionalBeanTest {

    @Autowired
    private ApplicationContext applicationContext;

    public static final String DEMO_TEST_ENV_VALUE = "test";

    static {
        System.setProperty("env", DEMO_TEST_ENV_VALUE);
    }

    @Test
    public void fetechSystemProperyServiceWhenSystemPropertyIsSet() {
        SystemPropertyService systemPropertyService = applicationContext.getBean(SystemPropertyService.class);
        assertThat(systemPropertyService, notNullValue());
        assertThat(systemPropertyService.getCurrentEnv(), equalTo(DEMO_TEST_ENV_VALUE));
    }
}
