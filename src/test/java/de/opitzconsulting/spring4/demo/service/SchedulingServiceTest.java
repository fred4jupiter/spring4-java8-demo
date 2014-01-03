package de.opitzconsulting.spring4.demo.service;

import de.opitzconsulting.spring4.demo.config.ApplicationConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Simple class starting the application context and show the scheduling features...
 */
public class SchedulingServiceTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        // NOTE: we don´t need to call the method on SchedulingService, because Spring will trigger it repeatedly
    }
}
