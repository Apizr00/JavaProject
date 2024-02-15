package Lesson8.Assignment1.Question12;

import java.util.List;

interface BankAccount {

    void deposit(double amount);

    void withdraw(double amount);

    double getBalance();

    void transfer(BankAccount destination, double amount);

    List<String> getTransactionHistory();
}