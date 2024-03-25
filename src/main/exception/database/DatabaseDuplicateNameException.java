package main.exception.database;

/**
 * Exception class for when a database entry with the same name already exists in the database.
 * @author Huang Yuchen
 * @author hyuchen@u.nus.edu
 */
public class DatabaseDuplicateNameException extends Exception {
    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the error message to be printed out
     */
    public DatabaseDuplicateNameException(String message) {
        super(message);
    }
}
