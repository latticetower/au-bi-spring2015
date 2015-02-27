package ru.spbau.malygina.task01;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        if (args.length < 1) {
            return; //TODO: check or add some exceptions
        }
        File inputFile = new File(args[0]);

        MessageWriter basicWriter = null;
        if (args.length < 2) {
            basicWriter = new ConsoleMessageWriter();
        } else {
            File outputFile = new File(args[1]);
            basicWriter = new FileMessageWriter(outputFile);
        }
        try (FileMessageReader reader = new FileMessageReader(inputFile)) {
            CompressingMessageWriter writer = new CompressingMessageWriter(basicWriter);
            while (true) {
                Message m = reader.readMessage();
                if (m == null) {
                    writer.close();
                    break;
                }
                writer.writeMessage(m);
            }
        }
        catch (IllegalMessageFormatException e) {
            System.out.println("Got exception while parsing input file: " + e.getMessage());

        }
        catch(IOException e) {
            System.out.println("Got exception while parsing input file: " + e.getMessage());
        }

    }
}
