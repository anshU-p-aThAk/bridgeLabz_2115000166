import java.util.*;

class BankAccount {
    protected String accountNumber;
    protected double balance;

    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void displayDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {

    protected double interestRate;

    public SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void displayDetails() {
        System.out.print("Savings Account: ");
        super.displayDetails();
        System.out.println("Interest Rate: " + interestRate);
    }

}

class CheckingAccount extends BankAccount {

    protected double withdrawalLimit;

    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    public void displayDetails() {
        System.out.print("Checking Account: ");
        super.displayDetails();
        System.out.println("Withdrawal Limit: " + withdrawalLimit);
    }
}

class FixedDepositAccount extends BankAccount {
    protected double interestRate;
    protected int duration;

    public FixedDepositAccount(String accountNumber, double balance, double interestRate, int duration) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
        this.duration = duration;
    }

    public void displayDetails() {
        System.out.print("Fixed Deposit Account: ");
        super.displayDetails();
        System.out.println("Interest Rate: " + interestRate);
        System.out.println("Duration: " + duration + " days");
    }
}

public class Bank {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount("123456", 5000.0, 0.05);
        CheckingAccount checkingAccount = new CheckingAccount("789012", 10000.0, 5000.0);
        FixedDepositAccount fixedDepositAccount = new FixedDepositAccount("345678", 20000.0, 0.05, 365);

        savingsAccount.displayDetails();
        checkingAccount.displayDetails();
        fixedDepositAccount.displayDetails();
    }
}
