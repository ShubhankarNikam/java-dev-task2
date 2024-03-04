package atmTask;

import java.util.Scanner;

public class ATMImpl implements ATMInterface {
    private double balance;
    private int pin;

    
    public ATMImpl(double initialBalance, int pin) {
    	
        this.balance = initialBalance;
        this.pin = pin;
    }

    @Override
    public  void checkBalance(int currentPin) {
    	if(pin == currentPin)
    	{
    		System.out.println("Your current balance is: " + balance +" Rs.");
    	}
    	else
    	{
    		System.out.println("Enter Correct Pin.");
    	}
        
    }

    @Override
    public void withdraw(double amount) {
    	if(amount>0)
    	{
    		if (amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawal successful. Please take your cash.");
            } else {
                System.out.println("Insufficient funds!!");
            }
    	}
    	else {
    		System.out.println("Enter valid amount!!");
    	}
        
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. Thank you for banking with us.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    @Override
    public void changePin(int currentPin, int newPin) {
        if (currentPin == pin) {
            pin = newPin;
            System.out.println("PIN change successful.");
        } else {
            System.out.println("Incorrect PIN.");
        }
    }

    public static void main(String[] args) {
        ATMImpl atm = new ATMImpl(1000.0, 1234); // Initial balance and PIN
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM");

        // Simulate ATM operations
        while (true) {
            System.out.println("1. Check Balance");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Change PIN");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                	System.out.println("Enter your Pin: ");
                	int pin = scanner.nextInt();
                    atm.checkBalance(pin);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: Rs.");
                    double withdrawAmount = scanner.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter amount to deposit: Rs.");
                    double depositAmount = scanner.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 4:
                    System.out.print("Enter current PIN: ");
                    int currentPin = scanner.nextInt();
                    System.out.print("Enter new PIN: ");
                    int newPin = scanner.nextInt();
                    atm.changePin(currentPin, newPin);
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
