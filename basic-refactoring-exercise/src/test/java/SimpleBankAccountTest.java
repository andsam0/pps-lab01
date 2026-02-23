import example.model.AccountHolder;
import example.model.BankAccount;
import example.model.SimpleBankAccount;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the SimpleBankAccount implementation
 */
class SimpleBankAccountTest {

    private static final int INITIAL_BALANCE = 0;
    private static final int DEPOSIT_AMOUNT = 100;
    private AccountHolder accountHolder;
    private BankAccount bankAccount;

    @BeforeEach
    void beforeEach(){
        accountHolder = new AccountHolder("Mario", "Rossi", 1);
        bankAccount = new SimpleBankAccount(accountHolder, INITIAL_BALANCE);
    }

    @Test
    void testInitialBalance() {
        assertEquals(INITIAL_BALANCE, bankAccount.getBalance());
    }

    @Test
    void testDeposit() {
        bankAccount.deposit(accountHolder.id(), DEPOSIT_AMOUNT);
        assertEquals(DEPOSIT_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWrongDeposit() {
        int otherUserAmount = 50;
        int otherUserId = 2;
        bankAccount.deposit(accountHolder.id(), DEPOSIT_AMOUNT);
        bankAccount.deposit(otherUserId, otherUserAmount);
        assertEquals(DEPOSIT_AMOUNT, bankAccount.getBalance());
    }

    @Test
    void testWithdraw() {

        int withdrawAmount = 50;
        doDepositAndWithdraw(accountHolder.id(), withdrawAmount);
        assertEquals(DEPOSIT_AMOUNT - withdrawAmount, bankAccount.getBalance());
    }

    @Test
    void testWrongWithdraw() {
        int otherUserId = 2;
        int withdrawAmount = 70;
        doDepositAndWithdraw(otherUserId, withdrawAmount);
        assertEquals(DEPOSIT_AMOUNT, bankAccount.getBalance());
    }

    private void doDepositAndWithdraw(int id, int withdrawAmount){
        bankAccount.deposit(accountHolder.id(), DEPOSIT_AMOUNT);
        bankAccount.withdraw(id, withdrawAmount);
    }
}
