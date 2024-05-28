package com.example.messaging_demo.controller;

import com.example.messaging_demo.service.MessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/message")
public class MessagingController {
    @Autowired
    MessagingService messagingService;
    @PostMapping(value = "/send", consumes = MediaType.TEXT_PLAIN_VALUE)
    public void sendMessageAsync(@RequestBody String body) {
        messagingService.sendMessageAsync(body);
    }
}
