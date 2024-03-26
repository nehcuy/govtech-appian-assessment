package main.parser;

import main.database.Database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parser {
    private final BufferedReader br;

    /**
     * Constructor for Parser class.
     * Initialises the BufferedReader object.
     */
    public Parser() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Reads the input from the user and returns a Database object.
     *
     * @return the Database object containing the expenditures of everyone
     */
    public Database readInput() {
        Database db = new Database();
        try {
            String row = br.readLine();
            while (!row.isEmpty()) {
                String[] entry = row.split(",");
                String name = entry[0];
                double amount = Double.parseDouble(entry[1]);
                db.addEntry(name, amount);
                row = br.readLine();
            }
            br.close();
            return db;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
