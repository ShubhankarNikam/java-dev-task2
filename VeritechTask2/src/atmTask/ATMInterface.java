package atmTask;

public interface ATMInterface {
	final int pin = 1234;
    void checkBalance(int pin);
    void withdraw(double amount);
    void deposit(double amount);
    void changePin(int currentPin, int newPin);
}
