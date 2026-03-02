package it.unibo.pps.e1;

public class BronzeBankAccount implements BankAccount {
    public static final int BRONZE_BANK_ACCOUNT_FEE = 1;
    public static final int MAX_NO_TAX_AMOUNT = 100;
    private final BankAccount base;

    public BronzeBankAccount(BankAccount base) {
        this.base = base;
    }

    @Override
    public int getBalance() {
        return base.getBalance();
    }

    @Override
    public void deposit(int amount) {
        base.deposit(amount);
    }

    @Override
    public void withdraw(int amount) {
        int finalAmount = amount + calculateFee(amount);
        if (this.getBalance() < finalAmount) {
            throw new IllegalStateException();
        }
        base.withdraw(finalAmount);
    }

    private int calculateFee(int amount) {
        return amount < MAX_NO_TAX_AMOUNT ? 0 : BRONZE_BANK_ACCOUNT_FEE;
    }
}
