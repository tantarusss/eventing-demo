package com.example.messaging_demo.service;

import jakarta.jms.*;

public class TextListener implements MessageListener {
    @Override
    public void onMessage(Message m) {
        try {
            if (m instanceof TextMessage) {
                System.out.println(
                        "Reading Message: " + m.getBody(String.class)
                );
            } else {
                System.out.println("Message is not a TextMessage");
            }
        } catch (JMSException | JMSRuntimeException e) {
            System.err.println("JMSException in onMessage(): " + e.toString());
        }
    }
}
