package com.example.messaging_demo;

import jakarta.jms.JMSException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MessagingDemoApplication {

	public static void main(String[] args) throws JMSException {
		manual manual = new manual();
		manual.send();
		manual.receive();
		SpringApplication.run(MessagingDemoApplication.class, args);
	}

}
