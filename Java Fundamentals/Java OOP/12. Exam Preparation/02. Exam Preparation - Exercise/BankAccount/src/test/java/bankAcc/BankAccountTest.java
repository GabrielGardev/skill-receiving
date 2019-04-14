package bankAcc;


import bankAccount.BankAccount;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

public class BankAccountTest {

    private static final String NAME = "Gosho";
    private static final BigDecimal BALANCE = new BigDecimal(100.0);

    private BankAccount bankAccount;

    @Before
    public void setUp() {
        this.bankAccount = new BankAccount(NAME, BALANCE);
    }

    @Test
    public void getNameShouldReturnName() {
        Assert.assertEquals(NAME, this.bankAccount.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorShouldThrowExceptionIfNameIsUnderThreeSymbols() {
        String newName = "Po";

        this.bankAccount = new BankAccount(newName, BALANCE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorShouldThrowExceptionIfNameIsOver25Symbols() {
        String newName = "Give me all your money woman!";

        this.bankAccount = new BankAccount(newName, BALANCE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructorShouldThrowExceptionIfBalanceIsNegative() {
        BigDecimal bigDecimal = new BigDecimal(-4);

        this.bankAccount = new BankAccount(NAME, bigDecimal);
    }


    @Test
    public void constructorShouldSetBankAccount() {
        BankAccount ba = new BankAccount(NAME, BALANCE);

        Assert.assertEquals(NAME, ba.getName());
        Assert.assertEquals(BALANCE, ba.getBalance());
    }

    @Test
    public void getBalanceShouldReturnCurrentBalance() {
        Assert.assertEquals(BALANCE, this.bankAccount.getBalance());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void depositShouldThrowExceptionIfAmountIsNegative() {
        this.bankAccount.deposit(new BigDecimal(-100.0));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void depositShouldThrowExceptionIfAmountIsZero() {
        this.bankAccount.deposit(new BigDecimal(0));
    }

    @Test
    public void depositShouldAddAmountToTheBalance() {
        this.bankAccount.deposit(new BigDecimal(100.0));

        Assert.assertEquals(new BigDecimal(200.0), this.bankAccount.getBalance());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void withdrawShouldThrowExceptionIfAmountIsNegative() {
        this.bankAccount.withdraw(new BigDecimal(-1));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void withdrawShouldThrowExceptionIfAmountIsMoreThenBalance() {
        this.bankAccount.withdraw(new BigDecimal(200));
    }

    @Test
    public void withdrawShouldSubtractGivenAmount() {
        BigDecimal bigDecimal = new BigDecimal(50);

        this.bankAccount.withdraw(bigDecimal);

        BigDecimal expected = BALANCE.subtract(bigDecimal);

        Assert.assertEquals(expected, this.bankAccount.getBalance());
    }

    @Test
    public void withdrawShouldReturnGivenAmount() {
        BigDecimal result = this.bankAccount.withdraw(new BigDecimal(50));


        Assert.assertEquals(new BigDecimal(50), result);
    }
}