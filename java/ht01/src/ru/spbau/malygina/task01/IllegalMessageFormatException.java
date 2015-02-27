package ru.spbau.malygina.task01;

/**
 * Created by T.Malygina on 28.02.15.
 */
public class IllegalMessageFormatException extends Exception {
    public IllegalMessageFormatException() {
    }

    public IllegalMessageFormatException(String message) {
        super(message);
    }

    public IllegalMessageFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalMessageFormatException(Throwable cause) {
        super(cause);
    }
}
