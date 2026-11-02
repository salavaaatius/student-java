package edu.course.lab02;

public class BankAccount {

    // Поле хранит текущий баланс счёта
    private int balance;

    // Конструктор
    public BankAccount(int initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }

        this.balance = initialBalance;
    }

    // Пополнение счёта
    public void deposit(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Amount must be positive");
        }

        if (amount > Integer.MAX_VALUE - balance) {
            throw new IllegalArgumentException(
                "Balance overflow");
        }

        balance += amount;
    }

    // Снятие денег
    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive");
        }

        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        balance -= amount;
    }

    // Получение текущего баланса
    public int getBalance() {
        return balance;
    }
}

