package ru.spbau.malygina.task01;

/**
 * Created by T.Malygina on 28.02.15.
 */
public class CompressingMessageWriter implements MessageWriter {
    private MessageWriter messageWriter;
    private Message message = null;

    public CompressingMessageWriter(MessageWriter messageWriter) {
        this.messageWriter = messageWriter;
    }

    @Override
    public void writeMessage(Message message) {

    }
}
