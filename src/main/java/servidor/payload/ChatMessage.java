package servidor.payload;

public class ChatMessage {
    public static final int VALID_USER = 1;
    public static final int SEND_RSA = 2;
    public static final int SEND_RND = 3;
    public static final int MISSATGE = 5;
    public static final int ERROR = 6;
    public static final int COMPLETED = 7;

    private int type;
    private String userFrom;
    private String userTo;
    private Object content;

    public ChatMessage(int type, String userFrom, String userTo, Object content) {
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

    public Object getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}
