package com.example.messaging_demo;

import com.example.messaging_demo.service.MessagingService;
import jakarta.jms.JMSException;

public class manual {
    MessagingService service;
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
