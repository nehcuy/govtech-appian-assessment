package main;

import main.calculator.Calculator;
import main.database.Database;
import main.parser.Parser;
import main.transaction.Transaction;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Database db = new Parser().readInput();
        Calculator calculator = new Calculator(db);
        List<Transaction> transactions = calculator.calculateTransactions();
        System.out.println("Number of transactions needed: " + transactions.size());
        System.out.println("Transactions: " + transactions);
    }
}
