package com.example.messaging_demo.service;

import com.example.messaging_demo.Listener;
import jakarta.jms.*;
import org.apache.activemq.artemis.jms.client.ActiveMQJMSConnectionFactory;
import org.apache.activemq.artemis.jms.client.ActiveMQJMSContext;
import org.springframework.stereotype.Service;

@Service
public class MessagingService {
    JMSContext context;
    ConnectionFactory connectionFactory;
    MessageListener listener;
    Destination tempQueue;

    public void sendMessage(String message) {
        context.createProducer().send(tempQueue, message);
    }
    public void receiveMessage() throws JMSException {
        JMSConsumer consumer = context.createConsumer(tempQueue);
        String msg = consumer.receive().getBody(String.class);
        System.out.println(msg);
    }
    public MessagingService() {
        connectionFactory = new ActiveMQJMSConnectionFactory("tcp://localhost:61616", "artemis", "artemis");
        listener = new Listener();
        context = connectionFactory.createContext();
        tempQueue = context.createTemporaryQueue();
    }
}
