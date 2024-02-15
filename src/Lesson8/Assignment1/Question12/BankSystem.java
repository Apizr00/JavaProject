package Lesson8.Assignment1.Question12;

public class BankSystem {
    public static void main(String[] args) {

        // Example usage
        SavingsAccount savingsAccount = new SavingsAccount();
        CheckingAccount checkingAccount = new CheckingAccount();

        savingsAccount.deposit(1000);
        savingsAccount.withdraw(200);

        checkingAccount.deposit(500);
        checkingAccount.transfer(savingsAccount, 100);

        // Display transaction history
        System.out.println("Savings Account Transactions:");

        for (String transaction : savingsAccount.getTransactionHistory()) {

            System.out.println(transaction);
        }

        System.out.println("\nChecking Account Transactions:");

        for (String transaction : checkingAccount.getTransactionHistory()) {

            System.out.println(transaction);
        }
    }
}