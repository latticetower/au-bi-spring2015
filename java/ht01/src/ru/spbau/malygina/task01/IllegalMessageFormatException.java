package ru.spbau.malygina.task01;

/**
 * @author T.Malygina
 * @version 28.02.15
 */
public class IllegalMessageFormatException extends Exception {
    public IllegalMessageFormatException() {
    }

    /**
     * @param message text with description of current exception
     * */
    public IllegalMessageFormatException(String message) {
        super(message);
    }

    /**
     * @param message text with description of current exception
     * @param cause reason of current exception
     * */
    public IllegalMessageFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param cause reason of current exception
     * */
    public IllegalMessageFormatException(Throwable cause) {
        super(cause);
    }
}
