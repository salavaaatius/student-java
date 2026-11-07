
package edu.course.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    @Test
    void createsAccountWithInitialBalance() {
        BankAccount account = new BankAccount(1000);

        assertEquals(1000, account.getBalance());
    }

    @Test
    void rejectsNegativeInitialBalance() {
        assertThrows(IllegalArgumentException.class,
                () -> new BankAccount(-100));
    }

    @Test
    void depositsMoney() {
        BankAccount account = new BankAccount(1000);

        account.deposit(500);

        assertEquals(1500, account.getBalance());
    }

    @Test
    void rejectsZeroDeposit() {
        BankAccount account = new BankAccount(1000);

        assertThrows(IllegalArgumentException.class,
                () -> account.deposit(0));
    }

    @Test
    void rejectsNegativeDeposit() {
        BankAccount account = new BankAccount(1000);

        assertThrows(IllegalArgumentException.class,
                () -> account.deposit(-100));
    }

    @Test
    void withdrawsMoneySuccessfully() {
        BankAccount account = new BankAccount(1000);

        account.withdraw(300);

        assertEquals(700, account.getBalance());
    }

    @Test
    void rejectsWithdrawalGreaterThanBalance() {
        BankAccount account = new BankAccount(100);

        assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(200));
    }

    @Test
    void rejectsZeroWithdrawal() {
        BankAccount account = new BankAccount(1000);

        assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(0));
    }

    @Test
    void rejectsNegativeWithdrawal() {
        BankAccount account = new BankAccount(1000);

        assertThrows(IllegalArgumentException.class,
                () -> account.withdraw(-100));
    }
    @Test
    void rejectsDepositOverflow() {
        BankAccount account = new BankAccount(Integer.MAX_VALUE);

        assertThrows(IllegalArgumentException.class,
                () -> account.deposit(1));
    }

    @Test
    void allowsWithdrawingEntireBalance() {
        BankAccount account = new BankAccount(500);

        account.withdraw(500);

        assertEquals(0, account.getBalance());
    }
}
