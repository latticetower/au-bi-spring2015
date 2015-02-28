package ru.spbau.malygina.task01;

import java.io.*;
import java.util.List;

/**
 * Class writes messages to given file.
 * @author T.Malygina
 * @version 28.02.15
 */
public class FileMessageWriter implements MessageWriter {
    private File file;
    private BufferedWriter bufferedWriter = null;

    /**
     * Constructor.
     * @param file file descriptor to write to
     * */
    public FileMessageWriter(File file) {
        if (file == null)
            throw new IllegalArgumentException("File cannot be null");
        this.file = file;
    }

    /**
     * Method writes message to file.
     * @param message text to be written to file
     * */
    @Override
    public void writeMessage(Message message) throws IOException {
        if (bufferedWriter == null) {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
        }
        List<String> lines = message.getLines();
        int linesCount = lines.size();
        bufferedWriter.write(Integer.toString(linesCount));
        bufferedWriter.newLine();

        for (String line: lines) {
            bufferedWriter.write(line);
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
    }

    /**
     * Method closes file.
     * @throws java.lang.Exception if I/O error occurs while closing file
     * */
    @Override
    public void close() throws Exception {
        if (bufferedWriter != null)
            bufferedWriter.close();
    }
}
