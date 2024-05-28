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
    MyCompletionListener completionListener;

    public void sendMessageAsync(String message) {
        context.createProducer().setAsync(completionListener);
    }
    public void sendMessage(String message) {
        System.out.println("Send Message called");
        context.createProducer().send(tempQueue, message);
    }
    private void startListener() {
        JMSConsumer consumer = context.createConsumer(tempQueue);
        consumer.setMessageListener(listener);
    }
    public void receiveMessage() throws JMSException {
        JMSConsumer consumer = context.createConsumer(tempQueue);
        String msg = consumer.receive().getBody(String.class);
        System.out.println(msg);
    }
    public MessagingService() {
        connectionFactory = new ActiveMQJMSConnectionFactory("tcp://localhost:61616", "artemis", "artemis");
        listener = new TextListener();
        context = connectionFactory.createContext();
        tempQueue = context.createTemporaryQueue();
        completionListener = new MyCompletionListener();
        startListener();
    }
}
