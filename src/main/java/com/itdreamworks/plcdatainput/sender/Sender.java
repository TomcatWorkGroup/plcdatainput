package com.itdreamworks.plcdatainput.sender;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Sender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void send(byte[] byteArray) {
		try {
			rabbitTemplate.convertAndSend(byteArray);
		} catch (AmqpException e) {
			System.out.println(e);
		}
	}
}