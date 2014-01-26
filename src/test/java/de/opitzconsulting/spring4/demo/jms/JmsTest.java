package de.opitzconsulting.spring4.demo.jms;

import de.opitzconsulting.spring4.demo.config.JmsConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JmsTest {

    static {
        System.setProperty("activemq.store.dir", "d://Temp1");
    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("activemq.store.dir", "d://Temp1");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JmsConfig.class);

        Sender sender = context.getBean(Sender.class);
        sender.sendMessage("Hello World!");

        Thread.sleep(200);
        context.close();
        System.exit(0);
    }
}
