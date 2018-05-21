package com.example.rabbitmq.publisher;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Publisher {
	
	@Autowired
	AmqpTemplate amqpTemplate;
	
	@Value("${srv.rabbitmq.exchange}")
	private String exchange;
	
	public void produceMsg(String message){
		amqpTemplate.convertAndSend(exchange, "", message);
		System.out.println("Send msg = " + message);
	}
}
