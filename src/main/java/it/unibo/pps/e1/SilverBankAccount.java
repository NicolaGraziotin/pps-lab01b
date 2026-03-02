package it.unibo.pps.e1;

public class SilverBankAccount implements BankAccount {

    public static final int SILVER_BANK_ACCOUNT_FEE = 1;
    private final BankAccount base;

    public SilverBankAccount(BankAccount base) {
        this.base = base;
    }

    public int getBalance() {
        return base.getBalance();
    }

    public void deposit(int amount) {
        base.deposit(amount);
    }

    public void withdraw(int amount) {
        if (this.getBalance() < amount + SILVER_BANK_ACCOUNT_FEE) {
            throw new IllegalStateException();
        }
        base.withdraw(amount + SILVER_BANK_ACCOUNT_FEE);
    }
}
