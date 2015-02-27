package ru.spbau.malygina.task01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by T.Malygina on 28.02.15.
 */
public class FileMessageReader {
    private File file;
    BufferedReader bufferedReader = null;

    public FileMessageReader(File file) {
        this.file = file;
    }

    public Message readMessage() throws IllegalMessageFormatException, IOException {
        if (bufferedReader == null)
            bufferedReader = new BufferedReader(new FileReader(file));
        String numStr = bufferedReader.readLine();
        int linesCount;
        try {
            linesCount = Integer.parseInt(numStr);
        } catch (NumberFormatException e) {
            throw new IllegalMessageFormatException("Could not parse number of lines in current message: " + numStr, e);
        }
        List<String> lines = new ArrayList<String>();
        for (int i = 0; i < linesCount; i++) {
            //TODO: add some logic to throw exception if file is finished before linesCount
            String s = bufferedReader.readLine();
            lines.add(s);
        }
        Message message = new Message(lines);
        return message;
    }
}
