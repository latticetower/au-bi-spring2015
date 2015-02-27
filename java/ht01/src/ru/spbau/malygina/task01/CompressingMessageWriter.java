package ru.spbau.malygina.task01;

import java.io.IOException;

/**
 * @author T.Malygina
 * @version 28.02.15
 */
public class CompressingMessageWriter implements MessageWriter {
    private MessageWriter messageWriter;
    private Message message = null;

    /**
     * @param messageWriter
     * */
    public CompressingMessageWriter(MessageWriter messageWriter) {
        this.messageWriter = messageWriter;
    }

    /**
     * @param message
     * */
    @Override
    public void writeMessage(Message message) throws IOException {
        if (this.message == null) {
            this.message = message;
            return;
        }
        this.message.appendMessage(message);
        messageWriter.writeMessage(this.message);
        this.message = null;
    }

    @Override
    public void close() throws IOException {
        if (this.message != null)
            messageWriter.writeMessage(this.message);
    }
}
