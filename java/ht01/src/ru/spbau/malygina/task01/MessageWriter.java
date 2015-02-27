package ru.spbau.malygina.task01;

import java.io.IOException;

/**
 * @author T.Malygina
 * @version 28.02.15
 */
public interface MessageWriter extends AutoCloseable {
    /**
     * @param message
     * */
    void writeMessage(Message message) throws IOException;
}
