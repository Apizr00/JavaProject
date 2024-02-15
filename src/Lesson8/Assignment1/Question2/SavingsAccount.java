package Lesson8.Assignment1.Question2;

class SavingsAccount implements BankAccount {

    private double balance;
    private double interestRate;

    public SavingsAccount(double initialBalance, double interestRate) {

        this.balance = initialBalance;
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
            applyInterest();
            System.out.println("Deposit successful. Current balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public void withdraw(double amount) {

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            applyInterest();
            System.out.println("Withdrawal successful. Current balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    @Override
    public double getBalance() {

        applyInterest();
        return balance;
    }

    private void applyInterest() {

        balance += balance * interestRate;
    }
}
