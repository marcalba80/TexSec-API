package servidor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import servidor.domain.Chat;
import servidor.payload.ChatMessage;
import servidor.repository.ChatRepository;
import servidor.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class ChatController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ChatRepository chatRepository;

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/chat")
    public void processMessage(@Payload ChatMessage chatMessage){
        System.out.println("Signup");
        // Chat chat = new Chat();
        // chat.setUser1(userRepository.findByUsername(chatMessage.getUserFrom()).get());
        // chat.setUser2(userRepository.findByUsername(chatMessage.getUserTo()).get());
        // chatRepository.save(chat);
        if(userRepository.findByUsername(chatMessage.getUserTo()).get().isSignin()){
            simpMessagingTemplate.convertAndSendToUser(chatMessage.getUserTo(), "/queue/messages", chatMessage);
        }
    }
}
