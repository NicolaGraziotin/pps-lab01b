package it.unibo.pps.e1;

public class GoldBankAccount implements BankAccount {
    public static final int MAX_OVERDRAFT = 500;
    private final BankAccount base;

    public GoldBankAccount(BankAccount base) {
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
        if (this.getBalance() + MAX_OVERDRAFT < amount) {
            throw new IllegalStateException();
        }
        base.withdraw(amount);
    }
}
