package de.opitzconsulting.spring4.demo.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    private static final Logger LOG = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    public void sendMessage(String message) {
        LOG.info("sendMessage: sending message: {}", message);
        jmsTemplate.send((session) -> session.createTextMessage(message));
    }
}
