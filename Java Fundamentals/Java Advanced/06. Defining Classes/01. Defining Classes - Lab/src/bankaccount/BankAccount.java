package bankaccount;

public class BankAccount {
    private final static double DEFAULT_INTEREST_RATE = 0.02;

    private static double InterestRate = DEFAULT_INTEREST_RATE;
    private static int bankAccountCount = 1;
    private int Id;
    private double Balance;

    BankAccount() {
        this.Id = bankAccountCount++;
        this.Balance = 0;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.InterestRate = interestRate;
    }

    void deposit(double amount){
        this.Balance += amount;
    }

    double getInterestRate(int years){
        return BankAccount.InterestRate * years * this.Balance;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public double getBalance() {
        return Balance;
    }

    public void setBalance(double balance) {
        Balance = balance;
    }
}
