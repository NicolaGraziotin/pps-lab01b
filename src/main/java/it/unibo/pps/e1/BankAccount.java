package it.unibo.pps.e1;

public interface BankAccount {

    /** @return the current balance of the account */
    int getBalance();

    /** Deposit the given amount of money into the account.
     * The amount must be positive. */
    void deposit(int amount);

    /** Withdraw the given amount of money from the account.
     * The amount must be positive and less than or equal to the current balance. */
    void withdraw(int amount);
}
