package de.opitzconsulting.spring4.demo.web.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Client side web socket handler.
 */
public class EchoClientEndpointWebSocketHandler extends TextWebSocketHandler {

    private static final Logger LOG = LoggerFactory.getLogger(EchoClientEndpointWebSocketHandler.class);

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        LOG.info("handleTextMessage: received message from server: {}", message.getPayload());
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);

        LOG.info("afterConnectionEstablished: connection established. sending message to server...");
        TextMessage textMessage = new TextMessage("Hello from client");
        session.sendMessage(textMessage);
    }
}
