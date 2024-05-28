package com.example.messaging_demo;

import com.example.messaging_demo.service.MessagingService;
import jakarta.jms.JMSException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;

@EnableAsync
public class manual {
    MessagingService service;
    @Async
    @Scheduled(fixedRate = 1000)
    public void sendAsync() {
        service.sendMessageAsync("Async Message");
    }
    public void send() {
        service.sendMessage("My Message");
    }
    public void receive() throws JMSException {
        service.receiveMessage();
    }
    public manual() {
        this.service = new MessagingService();
    }
}
