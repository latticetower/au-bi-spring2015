package ru.spbau.malygina.task01;

/**
 * Custom exception class to indicate that given file has wrong format.
 * @author T.Malygina
 * @version 28.02.15
 */
public class IllegalMessageFormatException extends Exception {
    /**
     * Default constructor
     * */
    public IllegalMessageFormatException() {
    }

    /** Constructor
     * @param message text with description of current exception
     * */
    public IllegalMessageFormatException(String message) {
        super(message);
    }

    /** Constructor
     * @param message text with description of current exception
     * @param cause reason of current exception
     * */
    public IllegalMessageFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    /** Constructor
     * @param cause reason of current exception
     * */
    public IllegalMessageFormatException(Throwable cause) {
        super(cause);
    }
}
