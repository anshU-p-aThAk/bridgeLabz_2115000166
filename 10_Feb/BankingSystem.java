import java.util.*;

abstract class BankAccount {
    private final String accountNumber;
    private final String holderName;
    private double balance;

    public BankAccount(String accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: ₹" + amount);
        } else {
            System.out.println("Invalid or insufficient balance.");
        }
    }

    public abstract double calculateInterest();

    public void displayDetails() {
        System.out.println("Account: " + accountNumber + " | Holder: " + holderName + " | Balance: ₹" + balance);
    }
}

interface Loanable {
    void applyForLoan(double amount);

    double calculateLoanEligibility();
}

class SavingsAccount extends BankAccount {
    private static final double INTEREST_RATE = 0.04;

    public SavingsAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }
}

class CurrentAccount extends BankAccount implements Loanable {
    private static final double INTEREST_RATE = 0.02;
    private static final double LOAN_ELIGIBILITY_FACTOR = 5;

    public CurrentAccount(String accountNumber, String holderName, double balance) {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * INTEREST_RATE;
    }

    @Override
    public void applyForLoan(double amount) {
        if (amount <= calculateLoanEligibility()) {
            System.out.println("Loan Approved for ₹" + amount);
        } else {
            System.out.println("Loan Denied. Eligible up to ₹" + calculateLoanEligibility());
        }
    }

    @Override
    public double calculateLoanEligibility() {
        return getBalance() * LOAN_ELIGIBILITY_FACTOR;
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(new SavingsAccount("SA101", "Alice", 50000));
        accounts.add(new CurrentAccount("CA202", "Bob", 80000));

        for (BankAccount account : accounts) {
            account.displayDetails();
            double interest = account.calculateInterest();
            System.out.println("Interest Earned: ₹" + interest);
            account.deposit(interest);
            System.out.println();
        }

        CurrentAccount currentAcc = new CurrentAccount("CA303", "Charlie", 100000);
        currentAcc.displayDetails();
        currentAcc.applyForLoan(300000);
    }
}
