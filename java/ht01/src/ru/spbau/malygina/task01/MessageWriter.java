package ru.spbau.malygina.task01;

import java.io.IOException;

/**
 * Created by T.Malygina on 28.02.15.
 */
public interface MessageWriter {
    void writeMessage(Message message) throws IOException;
}
