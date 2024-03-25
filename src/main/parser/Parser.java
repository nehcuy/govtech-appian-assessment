package main.parser;

import main.database.Database;

import java.util.Scanner;

public class Parser {
    private final Scanner sc;
    public Parser(Scanner sc) {
        this.sc = sc;
    }

    public Database readInput() {
        Database db = new Database();
        System.out.println("Enter 'exit' to finalise the calculations.");
        while (true) {
            // Prompt for name
            System.out.print("Enter name: ");
            String name = sc.next();

            // Check for "exit" to terminate the loop
            if (name.equalsIgnoreCase("exit")) {
                break;
            }

            // Prompt for amount
            System.out.print("Enter amount spent by " + name + ": ");
            while (!sc.hasNextDouble()) {
                System.out.println("Invalid amount. Please enter a number.");
                sc.next();
            }
            double amount = sc.nextDouble();
            db.addEntry(name, amount);
        }
        return db;
    }
}
