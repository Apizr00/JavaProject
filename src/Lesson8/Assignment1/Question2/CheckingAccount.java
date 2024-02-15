package Lesson8.Assignment1.Question2;

class CheckingAccount implements BankAccount {

    private double balance;
    private double overdraftLimit;

    public CheckingAccount(double initialBalance, double overdraftLimit) {

        this.balance = initialBalance;
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Current balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    @Override
    public void withdraw(double amount) {

        if (amount > 0 && (balance - amount) >= -overdraftLimit) {

            balance -= amount;
            System.out.println("Withdrawal successful. Current balance: " + balance);
        } else {

            System.out.println("Invalid withdrawal amount or exceeding overdraft limit.");
        }
    }

    @Override
    public double getBalance() {

        return balance;
    }
}
