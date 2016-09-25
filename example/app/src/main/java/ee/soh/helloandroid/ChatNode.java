package ee.soh.helloandroid;

/**
 * Created by hyeonsu on 2016. 9. 25..
 */
public class ChatNode {

    private String nickname;
    private String message;
    private String timestamp;
    private String nicknameColor;

    public ChatNode() {
        this.nickname = "";
        this.message = "";
        this.timestamp = "";
        this.nicknameColor = "#000000";
    }
    public ChatNode(String nickname, String message, String timestamp, String nicknameColor) {
        this.nickname = nickname;
        this.message = message;
        this.timestamp = timestamp;
        this.nicknameColor = nicknameColor;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNicknameColor() {
        return nicknameColor;
    }

    public void setNicknameColor(String nicknameColor) {
        this.nicknameColor = nicknameColor;
    }
}
