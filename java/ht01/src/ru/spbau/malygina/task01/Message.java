package ru.spbau.malygina.task01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by T.Malygina on 28.02.15.
 */
public class Message {
    private List<String> lines = new ArrayList<String>();

    public Message() {

    }

    public Message(List<String> lines) {
        this.lines.addAll(lines);
    }

    public void appendMessage(Message message) {
        lines.addAll(message.lines);
    }

    public List<String> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
