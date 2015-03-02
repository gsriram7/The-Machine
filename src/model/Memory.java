package model;

/**
 * Created by selvaram on 2/28/15.
 */
public class Memory {
    String message;
    String reply;

    public Memory(String message, String reply) {
        this.message = message;
        this.reply = reply;
    }

    public void printData() {
        System.out.println("#1:"+message+"\n#2"+reply);
    }

    public String getMessage() {
        return message;
    }

    public String getReply() {
        return reply;
    }
}
