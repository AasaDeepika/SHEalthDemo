/**
 * Created by sridhar on 3/12/2018.
 */

public class chatMessage {
    private String messageText;
    private String messageUser;

    public chatMessage(String messageText, String messageUser) {
        this.messageText = messageText;
        this.messageUser = messageUser;
    }

    public chatMessage() {
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getMessageUser() {
        return messageUser;
    }

    public void setMessageUser(String messageUser) {
        this.messageUser = messageUser;
    }
}
