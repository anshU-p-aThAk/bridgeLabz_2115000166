import java.util.*;

class BankingSystem {

    private static Map<Integer, Double> customerAccounts = new HashMap<>();

    private static Map<Integer, Double> sortedByBalance = new TreeMap<>(Comparator.comparing(customerAccounts::get));

    private static Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

    static class WithdrawalRequest {
        int accountNumber;
        double amount;

        WithdrawalRequest(int accountNumber, double amount) {
            this.accountNumber = accountNumber;
            this.amount = amount;
        }
    }

    public static void addCustomerAccount(int accountNumber, double balance) {
        customerAccounts.put(accountNumber, balance);
        sortedByBalance.put(accountNumber, balance);
    }

    public static void deposit(int accountNumber, double amount) {
        customerAccounts.put(accountNumber, customerAccounts.get(accountNumber) + amount);
        sortedByBalance.put(accountNumber, customerAccounts.get(accountNumber));
    }

    public static void withdraw(int accountNumber, double amount) {
        WithdrawalRequest request = new WithdrawalRequest(accountNumber, amount);
        withdrawalQueue.add(request);
    }

    public static void processWithdrawals() {
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest request = withdrawalQueue.poll();
            int accountNumber = request.accountNumber;
            double amount = request.amount;
            double currentBalance = customerAccounts.get(accountNumber);

            if (currentBalance >= amount) {
                customerAccounts.put(accountNumber, currentBalance - amount);
                sortedByBalance.put(accountNumber, currentBalance - amount);
                System.out.println("Withdrawal of $" + amount + " processed for account: " + accountNumber);
            } else {
                System.out.println("Insufficient balance for account: " + accountNumber);
            }
        }
    }

    public static void displayCustomerAccounts() {
        System.out.println("Customer Accounts (Unsorted): ");
        customerAccounts
                .forEach((accountNumber, balance) -> System.out.println("Account " + accountNumber + ": $" + balance));
    }

    public static void displaySortedCustomersByBalance() {
        System.out.println("Customers Sorted by Balance: ");
        sortedByBalance
                .forEach((accountNumber, balance) -> System.out.println("Account " + accountNumber + ": $" + balance));
    }

    public static void main(String[] args) {
        addCustomerAccount(101, 500.0);
        addCustomerAccount(102, 1000.0);
        addCustomerAccount(103, 150.0);

        displayCustomerAccounts();
        displaySortedCustomersByBalance();

        deposit(101, 200.0);
        withdraw(102, 500.0);
        withdraw(103, 200.0);

        processWithdrawals();

        displayCustomerAccounts();
        displaySortedCustomersByBalance();
    }
}
