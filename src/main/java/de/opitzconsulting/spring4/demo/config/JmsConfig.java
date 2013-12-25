package de.opitzconsulting.spring4.demo.config;

import de.opitzconsulting.spring4.demo.jms.Receiver;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.SimpleMessageListenerContainer;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;

@Configuration
@ComponentScan(basePackages = "de.opitzconsulting.spring4.demo.jms")
public class JmsConfig {

    public static final String QUEUE_NAME = "MSG_QUEUE_NAME";

    @Bean
    ConnectionFactory connectionFactory() {
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
        factory.setBrokerURL("vm://localhost?broker.persistent=false");
        return factory;
    }

//    @Bean
//    ConnectionFactory cachedConnectionFactory() {
//        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory();
//        cachingConnectionFactory.setTargetConnectionFactory(connectionFactory());
//        cachingConnectionFactory.setSessionCacheSize(10);
//        return cachingConnectionFactory;
//    }

    @Bean
    Destination destinationQueue() {
        return new ActiveMQQueue(QUEUE_NAME);
    }

    @Bean
    JmsTemplate jmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate();
        jmsTemplate.setConnectionFactory(connectionFactory());
        jmsTemplate.setDefaultDestination(destinationQueue());
        return jmsTemplate;
    }

    @Bean
    MessageListenerAdapter adapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver) {
            {
                setDefaultListenerMethod("receiveMessage");
            }
        };
    }

    @Bean
    SimpleMessageListenerContainer container(final MessageListenerAdapter messageListener, final ConnectionFactory connectionFactory) {
        return new SimpleMessageListenerContainer() {
            {
                setMessageListener(messageListener);
                setConnectionFactory(connectionFactory);
                setDestination(destinationQueue());
                setPubSubDomain(true);
            }
        };
    }
}
