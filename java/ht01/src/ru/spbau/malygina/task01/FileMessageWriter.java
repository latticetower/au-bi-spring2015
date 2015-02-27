package ru.spbau.malygina.task01;

import java.io.*;
import java.util.List;

/**
 * @author T.Malygina
 * @version 28.02.15
 */
public class FileMessageWriter implements MessageWriter {
    private File file;
    private BufferedWriter bufferedWriter = null;

    /**
     * @param file
     * */
    public FileMessageWriter(File file) {
        this.file = file;
    }

    /**
     * @param message
     * */
    @Override
    public void writeMessage(Message message) throws IOException {
        if (bufferedWriter == null)
            bufferedWriter = new BufferedWriter(new FileWriter(file));
        List<String> lines = message.getLines();
        int linesCount = lines.size();
        bufferedWriter.write(Integer.toString(linesCount));
        bufferedWriter.newLine();
        for (int i = 0; i < linesCount; i++) {
            bufferedWriter.write(lines.get(i));
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
    }

    @Override
    public void close() throws Exception {
        bufferedWriter.close();
    }
}
