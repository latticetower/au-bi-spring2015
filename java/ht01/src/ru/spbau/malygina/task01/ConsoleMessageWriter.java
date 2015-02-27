package ru.spbau.malygina.task01;

import java.io.IOException;
import java.util.List;

/**
 * @author T.Malygina
 * @version 28.02.15
 */
public class ConsoleMessageWriter implements MessageWriter {
    private int messagesWritten = 0;

    /**
     * @param message
     * */
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

    @Override
    public void close() throws IOException {

    }
}
