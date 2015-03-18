package ru.spbau.malygina.task02;

import ru.spbau.malygina.task02.commands.ArchiveCommand;
import ru.spbau.malygina.task02.commands.CompressCommand;
import ru.spbau.malygina.task02.commands.DecompressCommand;
import ru.spbau.malygina.task02.commands.ListCommand;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Main application class. Contains entry point for application..
 */
public class Main {

    /* constant values for cmd parameters, each correspond to its own data processing mode */
    public static final String CMD_COMPRESS = "compress";
    public static final String CMD_DECOMPRESS = "decompress";
    public static final String CMD_LIST = "list";

    /**
    * Application entry point.
    * @param args command line parameters
    */
     public static void main(String[] args) {
        String commandName = args[0];
        String fileName = args[1];
        ArchiveCommand cmd;

        if (commandName.equals(CMD_COMPRESS)) {
            List<String> sources = Arrays.asList(Arrays.copyOfRange(args, 2, args.length));
            cmd = new CompressCommand(fileName, sources);
        } else if (commandName.equals(CMD_DECOMPRESS)) {
            cmd = new DecompressCommand();
        } else if (commandName.equals(CMD_LIST)) {
            cmd = new ListCommand();
        } else {
            return;
        }

        try {
            cmd.run();
        } catch (IOException e) {
            e.printStackTrace();
            //TODO: do some meaningful processing
        }
    }


}
