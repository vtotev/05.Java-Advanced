package DefiningClasses.BankAccount;


public class BankAccount {
    private final static double Default_Interest_Rate = 0.02;
    private int id;
    private static int counter = 1;
    private double Balance;
    private static double InterestRate = Default_Interest_Rate;

    public double getInterest(int years) {
        return InterestRate * years * Balance;
    }

    public int getId() {
        return id;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }

    public static void setInterestRate(double interestRate) {
        InterestRate = interestRate;
    }

    public void deposit (double amount) {
        this.Balance += amount;
    }

    public BankAccount() {
        this.id = counter++;
    }
}
