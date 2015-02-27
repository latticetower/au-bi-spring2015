package ru.spbau.malygina.task01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author T.Malygina
 * @version 28.02.15
 */
public class FileMessageReader implements AutoCloseable {
    private File file;
    private BufferedReader bufferedReader = null;

    /** Default constructor
     * @param file
     * */
    public FileMessageReader(File file) {
        this.file = file;
    }

    /**
     * @return Message object if everything is ok, null if readLine returns null
     * @throws IllegalMessageFormatException
     *
     * */
    public Message readMessage() throws IllegalMessageFormatException, IOException {
        if (bufferedReader == null)
            bufferedReader = new BufferedReader(new FileReader(file));
        String numStr = bufferedReader.readLine();
        if (numStr == null)
            return null;
        int linesCount;
        try {
            linesCount = Integer.parseInt(numStr);
        } catch (NumberFormatException e) {
            throw new IllegalMessageFormatException("Could not parse number of lines in current message: " + numStr, e);
        }
        List<String> lines = new ArrayList<String>();
        for (int i = 0; i < linesCount; i++) {
            //TODO: add some logic to throw exception if file is finished before linesCount
            String messageStr = bufferedReader.readLine();
            if (messageStr == null)
                throw new IllegalMessageFormatException("File ended before message was read: expected " +
                        Integer.toString(linesCount) + " message line(s), got " + Integer.toString(i) + " message line(s)");
            lines.add(messageStr);
        }
        Message message = new Message(lines);
        return message;
    }


    @Override
    public void close() throws IOException {
        bufferedReader.close();
    }
}
