import java.util.*;

public class User {
    String name, email, password;
    double balance;
    List<Transaction> transactions;

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction("Deposit", amount));
            System.out.println("Deposited ₹" + amount);
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction("Withdraw", amount));
            System.out.println("Withdrew ₹" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    public void printTransactionHistory() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions.");
        } else {
            for (Transaction t : transactions) {
                System.out.println(t.type + ": ₹" + t.amount + " on " + t.date);
            }
        }
    }
}