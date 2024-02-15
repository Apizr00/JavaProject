package Lesson8.Assignment1.Question12;

import java.util.ArrayList;
import java.util.List;

class SavingsAccount implements BankAccount {

    private double balance;
    private List<Transaction> transactions;

    public SavingsAccount() {

        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    @Override
    public void deposit(double amount) {

        balance += amount;
        transactions.add(new Transaction("Deposit", amount));
    }

    @Override
    public void withdraw(double amount) {

        if (balance >= amount) {

            balance -= amount;
            transactions.add(new Transaction("Withdrawal", amount));

        } else {

            System.out.println("Insufficient funds");
        }
    }

    @Override
    public double getBalance() {

        return balance;
    }

    @Override
    public void transfer(BankAccount destination, double amount) {

        if (balance >= amount) {

            balance -= amount;
            transactions.add(new Transaction("Transfer to " + destination.getClass().getSimpleName(), amount));

            destination.deposit(amount);

        } else {

            System.out.println("Insufficient funds for transfer");
        }
    }

    @Override
    public List<String> getTransactionHistory() {

        List<String> history = new ArrayList<>();

        for (Transaction transaction : transactions) {

            history.add(transaction.toString());
        }
        return history;
    }
}
