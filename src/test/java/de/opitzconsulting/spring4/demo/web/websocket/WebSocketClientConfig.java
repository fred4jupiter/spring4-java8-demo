package de.opitzconsulting.spring4.demo.web.websocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.jetty.JettyWebSocketClient;

@Configuration
public class WebSocketClientConfig {

    @Bean
    public WebSocketClient webSocketClient() {
        //return new StandardWebSocketClient();
         return new JettyWebSocketClient();
    }

    @Bean
    public EchoClientEndpointWebSocketHandler clientWebSocketHandler() {
        return new EchoClientEndpointWebSocketHandler();
    }

    @Bean
    public WebSocketConnectionManager webSocketConnectionManager(WebSocketClient webSocketClient, WebSocketHandler webSocketHandler) {
        WebSocketConnectionManager manager = new WebSocketConnectionManager(webSocketClient, webSocketHandler, "ws://localhost:8080/spring4-java8-demo/echo");
        manager.setAutoStartup(true);
        return manager;
    }


}
