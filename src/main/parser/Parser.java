package main.parser;

import main.database.Database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Parser {
    BufferedReader br;
    public Parser() {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

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
