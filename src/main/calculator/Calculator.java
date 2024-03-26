package main.calculator;

import main.database.Database;
import main.person.Person;
import main.transaction.Transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a calculator object that does the main calculations for the program
 * given a Database object.
 * @author Huang Yuchen
 * @author hyuchen@u.nus.edu
 */
public class Calculator {
    private final int numberOfPeople;
    private final Database db;
    private static final double EPSILON = 0.01;

    /**
     * Constructor for Calculator class.
     *
     * @param db The Database object that contains the relevant mappings.
     */
    public Calculator(Database db) {
        this.numberOfPeople = db.getIdCount();
        this.db = db;
    }

    /**
     * Calculates the transactions needed to settle the debts.
     *
     * @return the list of transactions needed to settle the debts
     */
    public List<Transaction> calculateTransactions() {
        double sum = 0;
        double[] finalisedExpenditures = db.getExpenditureMap().stream().mapToDouble(Double::doubleValue).toArray();
        for (double i : finalisedExpenditures) {
            sum += i;
        }
        double costPerPerson = sum / numberOfPeople;
        for (int i = 0; i < numberOfPeople; i++) {
            finalisedExpenditures[i] -= costPerPerson;
        }
        List<Transaction> output = new ArrayList<>();
        calculateTransactionsRecursive(finalisedExpenditures, output);
        return output;
    }

    /**
     * Recursive helper function to calculate the transactions needed to settle the debts.
     *
     * @param amount The array of amounts of money that each person owes or is owed.
     * @param output The list of transactions that will be returned as the final output.
     */
    private void calculateTransactionsRecursive(double[] amount, List<Transaction> output) {
        int maxReceiveIdx = 0;
        int maxPaymentIdx = 0;
        for (int i = 1; i < numberOfPeople; ++i) {
            if (amount[i] < amount[maxPaymentIdx]) {
                maxPaymentIdx = i;
            }
            if (amount[i] > amount[maxReceiveIdx]) {
                maxReceiveIdx = i;
            }
        }

        if (amount[maxReceiveIdx] < EPSILON && amount[maxPaymentIdx] < EPSILON) {
            return;
        }

        double min = Math.min(-amount[maxPaymentIdx], amount[maxReceiveIdx]);
        amount[maxReceiveIdx] -= min;
        amount[maxPaymentIdx] += min;

        Person from = db.getPerson(maxPaymentIdx);
        Person to = db.getPerson(maxReceiveIdx);
        output.add(new Transaction(from, to, min));

        calculateTransactionsRecursive(amount, output);
    }
}
