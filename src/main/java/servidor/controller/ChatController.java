package servidor.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.web.bind.annotation.RestController;

import servidor.payload.ChatMessage;

@RestController
// @RequestMapping()
public class ChatController {
    
    @MessageMapping("/chat")
    public void processMessage(@Payload ChatMessage ChatMessage){
        
    }
}
