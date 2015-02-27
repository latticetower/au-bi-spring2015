package ru.spbau.malygina.task01;

import java.util.List;

/**
 * Created by T.Malygina on 28.02.15.
 */
public class ConsoleMessageWriter implements MessageWriter {
    private int messagesWritten = 0;

    @Override
    public void writeMessage(Message message) {
        messagesWritten ++;
        System.out.println("Message " + Integer.toString(messagesWritten));
        List<String> lines = message.getLines();
        int linesCount = lines.size();
        for (int i = 0; i < linesCount; i++) {
            System.out.print(Integer.toString(messagesWritten) + "." + Integer.toString(i) + ". ");
            System.out.println(lines.get(i));
        }
        System.out.flush();
    }
}
