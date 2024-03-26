package main.exception.calculator;

/**
 * Exception class for when the calculator has division errors such as divide by zero.
 * @author Huang Yuchen
 * @author hyuchen@u.nus.edu
 */
public class CalculatorDivisionErrorException extends Exception {
    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the error message to be printed out
     */
    public CalculatorDivisionErrorException(String message) {
        super(message);
    }
}
