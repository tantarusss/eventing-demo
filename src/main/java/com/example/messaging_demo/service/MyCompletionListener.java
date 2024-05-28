package com.example.messaging_demo.service;

import jakarta.jms.CompletionListener;
import jakarta.jms.Message;

public class MyCompletionListener implements CompletionListener {
    @Override
    public void onCompletion(Message message) {
        System.out.println("Message sent");
    }

    @Override
    public void onException(Message message, Exception e) {
        System.err.println("Error: " + e.getMessage());
    }
}
