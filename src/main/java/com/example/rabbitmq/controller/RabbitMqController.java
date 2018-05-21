package com.example.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.rabbitmq.publisher.Publisher;

@RestController
public class RabbitMqController {

	@Autowired
	Publisher publisher;
	
	@RequestMapping("/send")
	public String sendMessage(@RequestParam("msg")String message) {
		publisher.produceMsg(message);
		return "Done";
	}
}
