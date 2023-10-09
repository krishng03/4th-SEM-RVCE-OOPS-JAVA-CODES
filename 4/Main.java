import java.util.Scanner;

// Custom exception class 'DemonetizationException' that extends 'Exception'.
class DemonetizationException extends Exception {
    int amount;

    // Constructor for 'DemonetizationException' that takes the deposit amount as a parameter.
    DemonetizationException(int amount) {
        this.amount = amount;
    }

    // Method to print a custom error message when the deposit exceeds the limit.
    public void printMessage() {
        System.out.println("The Deposit Amount " + amount + " exceeds the limit of $5000!!");
    }
}

// 'Account' class to manage bank account operations.
class Account {
    int MIN_BALANCE = 500;
    int balance;

    // Constructor to initialize the balance with a minimum balance of $500.
    public Account() {
        balance = MIN_BALANCE;
    }

    // Method to deposit money into the account.
    public void deposit(int money, String curr) {
        if (curr.equals("OLD") && money > 5000) {
            try {
                // Throw 'DemonetizationException' when the deposit exceeds the limit.
                throw new DemonetizationException(money);
            } catch (DemonetizationException e) {
                e.printMessage();
                return;
            }
        }
        // Update the balance after a successful deposit.
        balance = balance + money;
        System.out.println("Deposit Successful!");
    }

    // Method to check and display the account balance.
    public void balance() {
        System.out.println("The Current Balance is $" + balance + ".\n");
    }

    // Method to withdraw money from the account.
    public void withdraw(int money) {
        if (balance - money < MIN_BALANCE)
            System.out.println("Withdrawal Failure!!");
        else {
            // Update the balance after a successful withdrawal.
            balance = balance - money;
            System.out.println("Withdrawal Successful!!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Account acc = new Account();
        System.out.print("~~BANK~~\n1. Deposit\n2. Check Balance\n3. Withdraw\n4. Exit\n");
        while (true) {
            System.out.print("Read Choice :\n>>> ");
            int ch = sc.nextInt(), money;
            String curr;
            switch (ch) {
                case 1:
                    System.out.print("Read Amount :\n>>> ");
                    money = sc.nextInt();
                    System.out.print("Read Currency Type :\n>>> ");
                    curr = sc.next();
                    // Call the 'deposit' method with the deposit amount and currency type.
                    acc.deposit(money, curr.toUpperCase());
                    break;
                case 2:
                    // Call the 'balance' method to check and display the account balance.
                    acc.balance();
                    break;
                case 3:
                    System.out.print("Read Amount :\n>>> ");
                    money = sc.nextInt();
                    // Call the 'withdraw' method with the withdrawal amount.
                    acc.withdraw(money);
                    break;
                default:
                    sc.close();
                    System.exit(0);
            }
        }
    }
}
