package it.unibo.pps.e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GoldBankAccountTest {

    private BankAccount account;

    @BeforeEach
    void init(){
        BankAccount base = new CoreBankAccount();
        this.account = new GoldBankAccount(base);
    }

    @Test
    public void testInitiallyEmpty() {
        int initialBalance = 0;
        assertEquals(initialBalance, this.account.getBalance());
    }

    @Test
    public void testCanDeposit() {
        int initialDeposit = 1000;
        this.account.deposit(initialDeposit);
        assertEquals(initialDeposit, this.account.getBalance());
    }

    @Test
    public void testCanWithdraw() {
        int initialDeposit = 1000;
        this.account.deposit(initialDeposit);
        int withdrawAmount = 200;
        this.account.withdraw(withdrawAmount);
        assertEquals(initialDeposit - withdrawAmount, this.account.getBalance());
    }

    @Test
    public void testCannotWithdrawMoreThanAvailableWithOverdraft(){
        int initialDeposit = 1000;
        this.account.deposit(initialDeposit);
        int withdrawAmount = initialDeposit + GoldBankAccount.MAX_OVERDRAFT + 1;
        assertThrows(IllegalStateException.class, () -> this.account.withdraw(withdrawAmount));
    }

    @Test
    public void testCanWithdrawWithOverdraft(){
        int initialDeposit = 1000;
        this.account.deposit(initialDeposit);
        int withdrawAmount = initialDeposit + GoldBankAccount.MAX_OVERDRAFT;
        this.account.withdraw(withdrawAmount);
        assertEquals(initialDeposit - withdrawAmount, this.account.getBalance());
    }
}
