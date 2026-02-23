package example.model;

public class FeeBankAccount implements BankAccount {

    private final BankAccount bankAccount;
    private static final int WITHDRAW_FEE = 1;
    public FeeBankAccount(final AccountHolder holder, final double balance) {
        this.bankAccount = new SimpleBankAccount(holder, balance);
    }

    @Override
    public double getBalance() {
        return this.bankAccount.getBalance();
    }

    @Override
    public void deposit(int userID, double amount) {
        this.bankAccount.deposit(userID, amount);
    }

    @Override
    public void withdraw(int userID, double amount) {
        this.bankAccount.withdraw(userID, amount+WITHDRAW_FEE);
    }
}
