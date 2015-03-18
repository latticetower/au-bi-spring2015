package ru.spbau.malygina.task02.commands;


import java.io.IOException;
/**
 * Basic interface for all archive manipulation commands
 * */
public interface ArchiveCommand {
    /**
     * */
    void run() throws IOException;
}
