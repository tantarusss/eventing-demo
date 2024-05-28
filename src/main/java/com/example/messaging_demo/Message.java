package com.example.messaging_demo;

import com.example.messaging_demo.model.MessageType;

public abstract class Message implements jakarta.jms.Message {
    MessageType type;
    String payload;
    Integer id;
}
