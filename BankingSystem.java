import java.util.*;

public class BankingSystem {
    static Scanner sc = new Scanner(System.in);
    static List<User> users = new ArrayList<>();
    static User currentUser = null;

    public static void main(String[] args) {
        System.out.println("Welcome to Banking Information System - Kunal Bharut");
        mainMenu();
    }

    static void mainMenu() {
        while (true) {
            System.out.println("\n1. Register\n2. Login\n3. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> register();
                case 2 -> login();
                case 3 -> {
                    System.out.println("Thank you for using the system!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static void register() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        users.add(new User(name, email, password));
        System.out.println("Registration successful!");
    }

    static void login() {
        System.out.print("Enter Email: ");
        String email = sc.nextLine();
        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        for (User u : users) {
            if (u.email.equals(email) && u.password.equals(password)) {
                currentUser = u;
                System.out.println("Welcome " + currentUser.name + "!");
                userMenu();
                return;
            }
        }
        System.out.println("Invalid credentials.");
    }

    static void userMenu() {
        while (true) {
            System.out.println("\n1. Check Balance\n2. Deposit\n3. Withdraw\n4. Transaction History\n5. Logout");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> System.out.println("Balance: ₹" + currentUser.balance);
                case 2 -> {
                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();
                    currentUser.deposit(amount);
                }
                case 3 -> {
                    System.out.print("Enter amount: ");
                    double amount = sc.nextDouble();
                    currentUser.withdraw(amount);
                }
                case 4 -> currentUser.printTransactionHistory();
                case 5 -> {
                    currentUser = null;
                    System.out.println("Logged out successfully.");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}