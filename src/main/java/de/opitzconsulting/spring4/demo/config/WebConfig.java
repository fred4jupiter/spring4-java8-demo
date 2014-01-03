
package de.opitzconsulting.spring4.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "de.opitzconsulting.spring4.demo.web")
@Import(ApplicationConfig.class)
public class WebConfig {

}