package ru.spbau.malygina.task01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Class-container for multiline text.
 * @author T.Malygina
 * @version 28.02.15
 */
public class Message {
    private List<String> lines = new ArrayList<String>();

    /**
     * Constructor.
     * @param lines message multiline text
     * */
    public Message(List<String> lines) {
        this.lines.addAll(lines);
    }

    /**
     * Method joins current message with provided one.
     * @param message message to join with, gets appended to current message lines
     * */
    public void appendMessage(Message message) {
        lines.addAll(message.lines);
    }

    /**
     * Method returns unmodifiable copy of current message content.
     * @return unmodifiable collection of strings
     * */
    public List<String> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
