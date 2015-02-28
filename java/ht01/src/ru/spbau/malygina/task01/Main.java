package ru.spbau.malygina.task01;

import java.io.File;
import java.io.IOException;

/**
 * Main entry point class.
 * */
public class Main {

    /**
     * Application entry point.
     * @param args command line parameters
     * */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: ");
            System.out.println(" First cmd parameter - input file name with messages");
            System.out.println(" Second cmd (optional) parameter - output file name with compressed messages");
            return;
        }
        File inputFile = new File(args[0]);
        if (!inputFile.exists()) {
            System.out.println("Couldn't find input file " + args[0] + ", exiting");
            return;
        }
        if (!inputFile.canRead()) {
            System.out.println("Input file named " + args[0] + " couldn't be read, exiting");
        }

        MessageWriter basicWriter = null;
        if (args.length < 2) {
            basicWriter = new ConsoleMessageWriter();
        } else {
            File outputFile = new File(args[1]);
            if (outputFile.exists() && !outputFile.canWrite()) {
                System.out.println("Output file named " + args[1] + " exists and couldn't be written to, exiting");
                return;
            }
            basicWriter = new FileMessageWriter(outputFile);
        }
        try (FileMessageReader reader = new FileMessageReader(inputFile)) {
            CompressingMessageWriter writer = new CompressingMessageWriter(basicWriter);
            while (true) {
                Message m = reader.readMessage();
                if (m == null) {
                    try {
                        writer.close();
                    } catch (Exception e) {
                        System.out.println("Couldn't call close() method for writer class: " + e.getMessage());
                    }
                    break;
                }
                writer.writeMessage(m);
            }
        } catch (IllegalMessageFormatException e) {
            System.out.println("Got exception while parsing input file: " + e.getMessage());
        } catch(IOException e) {
            System.out.println("Got I/O exception while processing data: " + e.getMessage());
        }
        System.out.println("All done, exiting");

    }
}
