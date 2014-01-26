package de.opitzconsulting.spring4.demo.web.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Server side web socket handler.
 */
public class EchoServerEndpointWebSocketHandler extends TextWebSocketHandler {

    private static final Logger LOG = LoggerFactory.getLogger(EchoServerEndpointWebSocketHandler.class);

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        LOG.info("handleTextMessage: received message from client: {}", payload);

        session.sendMessage(new TextMessage("Hello from server"));
    }
}
