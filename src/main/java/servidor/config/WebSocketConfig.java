package servidor.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer{

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        // TODO Auto-generated method stub
        registry.enableSimpleBroker("/user");
        registry.setApplicationDestinationPrefixes("/api");
        registry.setUserDestinationPrefix("/user");

    }

    @Override
    public boolean configureMessageConverters(List<MessageConverter> messageConverters) {
        // TODO Auto-generated method stub
        return WebSocketMessageBrokerConfigurer.super.configureMessageConverters(messageConverters);
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // TODO Auto-generated method stub
        registry.addEndpoint("/chat").withSockJS();
    }
    
}
