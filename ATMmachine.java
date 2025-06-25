
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class ATMmachine {
    float balance;
    int pin = 1234;
    Scanner sc = new Scanner(System.in);
    boolean exit = false;
    Map<Float, String> ministmt = new HashMap<>();

    public ATMmachine() {
        System.out.println("Enter ATM pin: ");
        int enteredpin = sc.nextInt();
        if (enteredpin == pin) {
            menu();
        } else {
            System.out.println("You've entered wrong pin!!!!!!!!!");
        }
    }

    private void menu() {
        while (!exit) {
            System.out.println("\n------ MENU ------");
            System.out.println("1) Check A/C Balance");
            System.out.println("2) Deposit cash");
            System.out.println("3) Withdraw");
            System.out.println("4) Mini statement");
            System.out.println("5) EXIT");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositCash();
                    break;
                case 3:
                    withdrawCash();
                    break;
                case 4:
                    miniStatement();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private void checkBalance() {
        System.out.println("Balance: " + balance);
    }

    private void depositCash() {
        System.out.print("Enter amount to deposit: ");
        float amount = sc.nextFloat();
        balance += amount;
        ministmt.put(amount, "Deposited");
        System.out.println("Amount deposited successfully.");
    }

    private void withdrawCash() {
        System.out.print("Enter amount to withdraw: ");
        float amount = sc.nextFloat();
        if (amount <= balance) {
            balance -= amount;
            ministmt.put(amount, "Withdrawn");
            System.out.println("Please collect your cash.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    private void miniStatement() {
        for (Map.Entry<Float, String> entry : ministmt.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        new ATMmachine();
    }
}
