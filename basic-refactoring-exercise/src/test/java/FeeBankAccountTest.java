import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.FeeBankAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeeBankAccountTest {
    private static final int DEPOSIT_AMOUNT = 100;
    private static final int INITIAL_BALANCE = 0;
    private static final int WITHDRAW_FEE = 1;
    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new FeeBankAccount(accountHolder, INITIAL_BALANCE);
    }

    @Test
    void testWithdraw() {
        int withdrawAmount = 50;
        bankAccount.deposit(accountHolder.id(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(accountHolder.id(), withdrawAmount);
        assertEquals(DEPOSIT_AMOUNT - withdrawAmount - WITHDRAW_FEE, bankAccount.getBalance());
    }
}
