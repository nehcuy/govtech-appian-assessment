package main.exception.parser;

import java.io.FileNotFoundException;

/**
 * Exception class for when the parser encounters invalid filepath input.
 * @author Huang Yuchen
 * @author hyuchen@u.nus.edu
 */
public class ParserFileNotFoundException extends FileNotFoundException {
    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the error message to be printed out
     */
    public ParserFileNotFoundException(String message) {
        super(message);
    }
}
