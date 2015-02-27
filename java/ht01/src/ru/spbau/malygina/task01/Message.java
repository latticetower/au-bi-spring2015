package ru.spbau.malygina.task01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author T.Malygina
 * @version 28.02.15
 */
public class Message {
    private List<String> lines = new ArrayList<String>();

    public Message() {

    }

    /**
     * @param lines
     * */
    public Message(List<String> lines) {
        this.lines.addAll(lines);
    }

    /**
     * @param message
     * */
    public void appendMessage(Message message) {
        lines.addAll(message.lines);
    }

    /**
     * @return
     * */
    public List<String> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
