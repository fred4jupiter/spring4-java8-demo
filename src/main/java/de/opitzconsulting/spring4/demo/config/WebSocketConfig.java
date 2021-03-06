package de.opitzconsulting.spring4.demo.config;

import de.opitzconsulting.spring4.demo.web.websocket.EchoServerEndpointWebSocketHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.handler.PerConnectionWebSocketHandler;

@Configuration
@EnableWebSocket
@ComponentScan(basePackages = "de.opitzconsulting.spring4.demo.web.websocket")
@Import(WebConfig.class)
public class WebSocketConfig extends WebMvcConfigurerAdapter implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(echoWebSocketHandler(), "/echo");
        registry.addHandler(echoWebSocketHandler(), "/sockjs/echo").withSockJS();
    }

    @Bean
    public WebSocketHandler echoWebSocketHandler() {
//        return new EchoServerEndpointWebSocketHandler();

        // stateful per session handler
        return new PerConnectionWebSocketHandler(EchoServerEndpointWebSocketHandler.class);
    }

    // Allow serving HTML files through the default Servlet
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
}
