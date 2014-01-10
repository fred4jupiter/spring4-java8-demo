package de.opitzconsulting.spring4.demo;

import de.opitzconsulting.spring4.demo.config.AppConfig;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Example for a composed annotation in tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ContextConfiguration(classes = AppConfig.class)
@ActiveProfiles("dev")
@Transactional
public @interface TransactionalAppConfigDevTest {
}
