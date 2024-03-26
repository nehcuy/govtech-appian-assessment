package main;

import main.calculator.Calculator;
import main.database.Database;
import main.parser.Parser;
import main.transaction.Transaction;

import java.util.List;

/**
 * Main class that runs the program.
 * Parses the input, calculates the transactions and prints the output.
 * @author Huang Yuchen
 * @author hyuchen@u.nus.edu
 */
public class Main {
    public static void main(String[] args) {
        Database db = new Parser().readInput();
        Calculator calculator = new Calculator(db);
        List<Transaction> transactions = calculator.calculateTransactions();
        System.out.println("Number of transactions needed: " + transactions.size());
        System.out.println("Transactions: " + transactions);
    }
}
