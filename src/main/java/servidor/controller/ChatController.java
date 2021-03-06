package servidor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
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
    // @PostMapping("/chat")
    public void processMessage(@Payload /*@RequestBody*/ ChatMessage chatMessage){
        System.out.println("Chat");
        Chat chat = new Chat();
        chat.setUser1(userRepository.findByUsername(chatMessage.getUserFrom()).get());
        chat.setUser2(userRepository.findByUsername(chatMessage.getUserTo()).get());
        
        if(!chatRepository.chatExists(chatMessage.getUserFrom(), chatMessage.getUserTo())){
            System.out.println("Chat save");
            chatRepository.save(chat);
        }
        if(userRepository.findByUsername(chatMessage.getUserTo()).get().isSignin()){
            
            System.out.println("Chat send");
            simpMessagingTemplate.convertAndSendToUser(chatMessage.getUserTo(), "/queue/messages", chatMessage);
        }
    }
}
