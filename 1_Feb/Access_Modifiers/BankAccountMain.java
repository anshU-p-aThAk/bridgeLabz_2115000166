import java.util.*;

class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class SavingsAccount extends BankAccount {
    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
    }
}

public class BankAccountMain {
    public static void main(String[] args) {
        BankAccount b = new BankAccount();
        b.accountNumber = "123456789";
        b.setBalance(5000.0);

        SavingsAccount sa = new SavingsAccount();
        sa.accountNumber = "987654321";
        sa.accountHolder = "John Doe";
        sa.displayAccountInfo();
    }
}
