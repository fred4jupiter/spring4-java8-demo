package de.opitzconsulting.spring4.demo.web.websocket;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.TimeUnit;

public class EchoWebSocketClientTest {

    public static void main(String[] args) throws InterruptedException {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WebSocketClientConfig.class)) {
            TimeUnit.MINUTES.sleep(1);
        }
    }
}
