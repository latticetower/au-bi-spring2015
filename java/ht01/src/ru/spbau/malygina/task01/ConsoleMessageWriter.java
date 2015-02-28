package ru.spbau.malygina.task01;

import java.util.List;

/**
 * Class writes incoming messages to console.
 * @author T.Malygina
 * @version 28.02.15
 */
public class ConsoleMessageWriter implements MessageWriter {
    private int messagesWritten = 0;

    /**
     * Method writes message to console.
     * @param message text to be written to console
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

    /**
     * Method should close resource, does nothing (console needn't to be closed).
     * */
    @Override
    public void close() {
        System.out.flush();//at this moment everything should be flushed already, this is just in case

    }
}
