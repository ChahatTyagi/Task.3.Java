# Task.3.Java
import java.util.Scanner;
public class ATM 
{
    private BankAccount account;
    private Scanner scanner;
    public ATM(BankAccount account) 
    {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }
    public void run() 
    {
        while (true) 
        {
            displayMenu();
            int option = scanner.nextInt();
            switch (option) 
            {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Have a nice day!");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
    private void displayMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }
    private void checkBalance() 
    {
        System.out.println("Your balance: Rs." + account.getBalance());
    }
    private void deposit() 
    {
        System.out.print("Enter amount to deposit: Rs.");
        double amount = scanner.nextDouble();
        if (amount <= 0) 
        {
            System.out.println("Deposited amount must be greater than zero.");
        } 
        else 
        {
            account.deposit(amount);
        }
    }
    private void withdraw() 
    {
        System.out.print("Enter amount to withdraw: Rs.");
        double amount = scanner.nextDouble();
        if (amount <= 0) 
        {
            System.out.println("Withdrawal amount must be greater than zero.");
        } else 
        {
            boolean success = account.withdraw(amount);
            if (success) 
            {
                System.out.println("Please take your money.");
            }
        }
    }
    public static void main(String args[]) 
    {
        BankAccount userAccount = new BankAccount(500); 
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}
public class BankAccount 
{
    double balance;
     BankAccount(double balance) 
    {
        balance = balance;
    }
    double getBalance() 
    {
        return balance;
    }
    void deposit(double amount) 
    {
        balance = balance + amount;
        System.out.println("Deposited: Rs." + amount);
    }
    public boolean withdraw(double amount) 
    {
        if (amount <= balance) 
        {
            balance = balance - amount;
            System.out.println("Withdrawn: Rs." + amount);
            return true;
        } 
        else 
        {
            System.out.println("Insufficient Amount. Withdrawal failed.");
            return false;
        }
    }
}
