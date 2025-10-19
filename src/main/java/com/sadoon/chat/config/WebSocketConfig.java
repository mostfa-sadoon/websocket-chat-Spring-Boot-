package com.sadoon.chat.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Messages whose destination starts with "/topic" will go to the broker
        config.enableSimpleBroker("/topic");

        // Messages starting with "/app" will be routed to @MessageMapping controllers
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // This is the endpoint clients will use to connect to your WebSocket
        registry.addEndpoint("/ws")
                .setAllowedOriginPatterns("*")  // allow all origins (for development)
                .withSockJS(); // fallback for browsers that don't support WebSocket
    }
}
