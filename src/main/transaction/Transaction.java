package main.transaction;

import main.person.Person;

/**
 * Represents a transaction object that is to be returned as the final output.
 * @author Huang Yuchen
 * @author hyuchen@u.nus.edu
 */
public class Transaction {
    private final Person from;
    private final Person to;
    private final double amount;

    /**
     * Constructor for Transaction class.
     *
     * @param from The person who is paying.
     * @param to The person who is receiving the payment.
     * @param amount The amount of money involved in the transaction.
     */
    public Transaction(Person from, Person to, double amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    /**
     * Getter for the person making the payment.
     *
     * @return the person who is paying
     */
    public Person getPersonToMakePayment() {
        return this.from;
    }

    /**
     * Getter for the person receiving the payment.
     *
     * @return the person who is receiving the payment
     */
    public Person getPersonToReceivePayment() {
        return this.to;
    }

    /**
     * Getter for the amount of money involved in the transaction.
     *
     * @return the amount of money involved in the transaction
     */
    public double getAmount() {
        return this.amount;
    }

    /**
     * Returns the String representation of the transaction object.
     *
     * @return the String representation of the transaction object
     */
    @Override
    public String toString() {
        return "(" + from.getName() + " -> " + to.getName() + ": "
                + String.format("$%.2f", amount) + ")";
    }
}
