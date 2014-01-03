package de.opitzconsulting.spring4.demo.service;

import de.opitzconsulting.spring4.demo.config.ActivateSchedulingCondition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Conditional;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;



public class SchedulingService {

    private static final Logger LOG = LoggerFactory.getLogger(SchedulingService.class);

    @Scheduled(cron = "*/5 * * * * ?")
    public void printSomethingRepeatable() {
        LOG.info("printSomethingRepeatable: current time: {}", LocalDateTime.now());
    }
}
