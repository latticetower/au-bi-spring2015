package ru.spbau.malygina.task01;

import java.io.IOException;

/**
 * @author T.Malygina
 * @version 28.02.15
 */
public interface MessageWriter extends AutoCloseable {
    /** Method processes given message
     * @param message data to be written
     * */
    void writeMessage(Message message) throws IOException;
}
