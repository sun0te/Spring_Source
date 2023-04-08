package com.mysite.spring_chatbot0407;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ws").withSockJS();	//연결할 웹 소켓 엔드포인트를 지칭하는 부분
	}

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// topic이라는 토픽에 대하여 구독을 신청했을 때 실제 경로는 /app/topic 이 된다.
		registry.setApplicationDestinationPrefixes("/app");	//도착 경로에 대한 prefix 설정
		registry.enableSimpleBroker("/topic");
	}
	
}
