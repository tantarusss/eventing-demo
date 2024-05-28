package com.example.messaging_demo;

public interface EventHandler {
    boolean canHandle(Message message);
    void handle();
}
