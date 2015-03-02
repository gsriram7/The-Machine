package model;

/**
 * Created by selvaram on 3/2/15.
 */
public class User {

    Memory memory;
    String from;
    String to;

    public User(Memory memory, String from, String to) {
        this.memory = memory;
        this.from = from;
        this.to = to;
    }

    public Memory getMemory() {
        return memory;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
}
