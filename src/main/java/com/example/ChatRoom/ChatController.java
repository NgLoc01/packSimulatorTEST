package com.example.ChatRoom;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/* 
@Controller
public class ChatController {

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(Message message) throws Exception {
        Thread.sleep(500); // Simulated delay
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        return new OutputMessage(message.getFrom(), message.getContent(), time);
    }
}
*/
@Controller
public class ChatController {
    private final ScryfallService scryfallService;

    public ChatController(ScryfallService scryfallService) {
        this.scryfallService = scryfallService;
    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(Message message) throws Exception {
        Thread.sleep(500);
        CardResponse card = scryfallService.fetchRandomCard();
        String time = LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        return new OutputMessage(
            message.getFrom(),
            message.getContent(),
            time,
            card.getName(),
            card.getImageUris().getNormal()
        );
    }
}