package de.opitzconsulting.spring4.demo.service;

import de.opitzconsulting.spring4.demo.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Simple class starting the application context and show the scheduling features...
 */
public class SchedulingServiceTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("scheduling");
        context.register(AppConfig.class);
        context.refresh();
        // NOTE: we don´t need to call the method on SchedulingService, because Spring will trigger it repeatedly
    }
}
