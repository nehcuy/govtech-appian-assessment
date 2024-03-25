package main.calculator;

import main.database.Database;
import main.person.Person;
import main.transaction.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private final int numberOfPeople;
    private final Database db;

    public Calculator(Database db) {
        this.numberOfPeople = db.getIdCount();
        this.db = db;
    }

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

    private void calculateTransactionsRecursive(double[] amount, List<Transaction> output) {
        int maxReceiveIdx = 0, maxPaymentIdx = 0;
        for (int i = 1; i < numberOfPeople; ++i) {
            if (amount[i] < amount[maxPaymentIdx]) {
                maxPaymentIdx = i;
            }
            if (amount[i] > amount[maxReceiveIdx]) {
                maxReceiveIdx = i;
            }
        }

        if (amount[maxReceiveIdx] == 0 && amount[maxPaymentIdx] == 0)
            return;

        double min = Math.min(-amount[maxPaymentIdx], amount[maxReceiveIdx]);
        amount[maxReceiveIdx] -= min;
        amount[maxPaymentIdx] += min;

        Person from = db.getPerson(maxPaymentIdx);
        Person to = db.getPerson(maxReceiveIdx);
        output.add(new Transaction(from, to, min));

        calculateTransactionsRecursive(amount, output);
    }
}
