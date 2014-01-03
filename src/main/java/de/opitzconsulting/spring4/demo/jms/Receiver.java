package de.opitzconsulting.spring4.demo.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * NOTE: The @JmsListener message receiving is not yet implemented
 *
 * @see https://jira.springsource.org/browse/SPR-9882
 */
@Component
public class Receiver {

    private static final Logger LOG = LoggerFactory.getLogger(Receiver.class);

    public void receiveMessage(String message) {
        LOG.info("receiveMessage: received message: {}", message);
    }
}
