package servidor.payload;

public class ChatMessage {
    public static final int VALID_USER = 1;
    public static final int MISSATGE = 5;

    private int type;
    private String userFrom;
    private String userTo;
    private String content;

    public ChatMessage(int type, String userFrom, String userTo, String content) {
        this.type = type;
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUserFrom() {
        return userFrom;
    }

    public void setUserFrom(String userFrom) {
        this.userFrom = userFrom;
    }

    public String getUserTo() {
        return userTo;
    }

    public void setUserTo(String userTo) {
        this.userTo = userTo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}
