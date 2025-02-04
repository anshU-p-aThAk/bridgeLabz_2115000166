import java.util.*;

class BankAccount {
    private static String bankName = "Global Bank";
    private static int totalAccounts = 0;
    private final int accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountHolderName, int accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
        totalAccounts++;
    }

    public void displayDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank: " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: $" + balance);
        }
    }

    public static void getTotalAccounts() {
        System.out.print("Total accounts: " + totalAccounts);
    }
}

public class BankMain {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("John Doe", 123456789, 1000.00);
        BankAccount account2 = new BankAccount("Jane Smith", 987654321, 500.00);
        BankAccount.getTotalAccounts();
        account1.displayDetails();
        account2.displayDetails();
    }
}