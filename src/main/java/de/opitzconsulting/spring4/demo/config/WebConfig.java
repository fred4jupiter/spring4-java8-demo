
package de.opitzconsulting.spring4.demo.config;

import de.opitzconsulting.spring4.demo.repository.PersonRepository;
import de.opitzconsulting.spring4.demo.web.rest.DemoDataPopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "de.opitzconsulting.spring4.demo.web.rest")
@Import(AppConfig.class)
public class WebConfig {

    @Autowired
    private PersonRepository personRepository;

    @Bean
    @Conditional(RunningInJettyCondition.class)
    public DemoDataPopulator demoDataPopulator() {
        return new DemoDataPopulator(personRepository);
    }
}