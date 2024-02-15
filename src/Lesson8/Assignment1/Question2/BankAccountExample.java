package Lesson8.Assignment1.Question2;

public class BankAccountExample {

    public static void main(String[] args) {

        SavingsAccount savingsAccount = new SavingsAccount(1000, 0.05);
        CheckingAccount checkingAccount = new CheckingAccount(500, 200);

        savingsAccount.deposit(200);
        savingsAccount.withdraw(50);
        System.out.println("Savings Account Balance: " + savingsAccount.getBalance());

        checkingAccount.deposit(100);
        checkingAccount.withdraw(300);
        System.out.println("Checking Account Balance: " + checkingAccount.getBalance());
    }

}
