package servidor.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity

public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    private String chatId;

    @OneToOne
    @JoinColumn(name = "user1Id")
    private User user1;

    @OneToOne
    @JoinColumn(name = "user2Id")
    private User user2;

    public Chat(){
        
    }

    public Chat(String id, User user1, User user2) {
        this.chatId = id;
        this.user1 = user1;
        this.user2 = user2;
    }

    public Chat(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
    }

    public Long getId() {
        return id;
    }

    public String getChatId() {
        return chatId;
    }

    public User getUser1() {
        return user1;
    }

    public void setUser1(User user1) {
        this.user1 = user1;
    }

    public User getUser2() {
        return user2;
    }

    public void setUser2(User user2) {
        this.user2 = user2;
    }

    
}
