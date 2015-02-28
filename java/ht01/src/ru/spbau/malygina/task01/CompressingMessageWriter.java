package ru.spbau.malygina.task01;

import java.io.IOException;

/**
 * Class wraps inner MessageWriter object, joins pairs of messages passed to writeMessage
 * and sends them to inner MessageWriter object.
 * @author T.Malygina
 * @version 28.02.15
 */
public class CompressingMessageWriter implements MessageWriter {
    private MessageWriter messageWriter;
    private Message message = null;

    /** Default constructor.
     * @param messageWriter inner object to write processed messages to
     * */
    public CompressingMessageWriter(MessageWriter messageWriter) {
        if (messageWriter == null)
            throw new IllegalArgumentException("MessageWriter cannot be null");
        this.messageWriter = messageWriter;
    }

    /** Method processes incoming message
     * @param message Message object to be processed
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

    /**
     * Method writes unwritten and closes inner MessageWriter object.
     * @throws java.lang.Exception if resource is uncloseable or inner MessageWriter throws Exception
     * */
    @Override
    public void close() throws Exception {
        if (this.message != null) {
            messageWriter.writeMessage(this.message);
        }
        messageWriter.close();
    }
}
