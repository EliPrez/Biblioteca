package com.biblioteca.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {

        //Mensajes desde el servidor hacia el cliente

        config.enableSimpleBroker("/topic");

        //Peticiones del cliente para el servidor
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {

        // Punto de entrada para conectarse al WebSocket desde el Frontend
        registry.addEndpoint("/ws-biblioteca")
                .setAllowedOriginPatterns("*")
                .withSockJS();
    }
}