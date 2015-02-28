package ru.spbau.malygina.task01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class reads messages from file.
 * @author T.Malygina
 * @version 28.02.15
 */
public class FileMessageReader implements AutoCloseable {
    private File file;
    private BufferedReader bufferedReader = null;

    /**
     * Default constructor.
     * @param file file descriptor to be read from
     * */
    public FileMessageReader(File file) {
        if (file == null)
            throw new IllegalArgumentException("File cannot be null");
        this.file = file;
    }

    /**
     * Method reads next message from file.
     * @return Message object if everything is ok, null if readLine returns null (thus indicating end of file)
     * @throws IllegalMessageFormatException if input file format is incorrect
     * (negative or non-numeric number of lines in message, file ends before all lines are read)
     * @throws java.io.IOException If an I/O error occurs
     * */
    public Message readMessage() throws IllegalMessageFormatException, IOException {
        if (bufferedReader == null)
            bufferedReader = new BufferedReader(new FileReader(file));

        String numStr = bufferedReader.readLine();
        if (numStr == null) {
            return null;
        }

        int linesCount;
        try {
            linesCount = Integer.parseInt(numStr);
        } catch (NumberFormatException e) {
            throw new IllegalMessageFormatException("Could not parse number of lines in current message: " + numStr, e);
        }
        if (linesCount < 0)
            throw new IllegalMessageFormatException("Number of lines in message must be non-negative, got " + numStr);

        List<String> lines = new ArrayList<String>();
        for (int i = 0; i < linesCount; i++) {
            String messageStr = bufferedReader.readLine();
            if (messageStr == null) {
                throw new IllegalMessageFormatException("File ended before message was read: expected " +
                        Integer.toString(linesCount) + " message line(s), got " + Integer.toString(i) +
                        " message line(s)");
            }
            lines.add(messageStr);
        }
        Message message = new Message(lines);
        return message;
    }


    /**
     * Method closes reader object.
     * @throws java.io.IOException - if I/O error occurs while calling close() method in inner BufferedReader object
     * */
    @Override
    public void close() throws IOException {
        if (bufferedReader != null)
            bufferedReader.close();
    }
}
