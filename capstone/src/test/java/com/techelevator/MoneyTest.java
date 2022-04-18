package com.techelevator;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    @Test
    void purchaseIsCoveredShouldReturnTrue() { //make sure returns only false if less than zero, write test to pass (2 tests)
        Money money = new Money();
        BigDecimal testAmount = new BigDecimal("7.0");
        BigDecimal balance = new BigDecimal("10.0");
        money.addBalance(balance);
        assertTrue(money.purchaseIsCovered(testAmount));
    }
    @Test
    void purchaseIsCoveredShouldReturnFalse() { //make sure returns only false if less than zero, write test to pass (2 tests)
        Money money = new Money();
        BigDecimal testAmount = new BigDecimal("15.0");
        BigDecimal balance = new BigDecimal("8.0");
        money.addBalance(balance);
        assertFalse(money.purchaseIsCovered(testAmount));
    }

    @Test
    public void testBalanceDeduct() { //test that method does not add to balance, test that it works (2 tests)
    Money money = new Money();
    BigDecimal moneyToDeduct = new BigDecimal("7.0");
    money.addBalance(moneyToDeduct);
    money.balanceDeduct(new BigDecimal("4.0"));
    assertEquals(new BigDecimal("3.0"), money.getBalance());
    }

    @Test
    public void testFeedMoney() {//test exception thrown and exception passed (2 tests)
        Money money = new Money();
        String testInput = "5.00";
        InputStream in = new ByteArrayInputStream(testInput.getBytes(StandardCharsets.UTF_8));
        System.setIn(in);
        assertTrue(money.feedMoney());
    }

    @Test
    public void testFeedMoneyException() {//test exception thrown and exception passed (2 tests)
        // since feedMoney() has a recursive catch block instead of a NumberFormatExeception it throws a NoSuchElementException
        assertThrows(NoSuchElementException.class, () -> {
           Money money = new Money();
           String testInput = "TEST";
           InputStream in = new ByteArrayInputStream(testInput.getBytes(StandardCharsets.UTF_8));
           System.setIn(in);
           money.feedMoney();
       });
    }

    @Test
    public void testChangeCalculator() { //test that output is correct
    Money money = new Money();
    BigDecimal remainingChange = new BigDecimal("3.0");
    money.addBalance(remainingChange);
    int[] changeArr = {12, 0 ,0};
    assertArrayEquals(changeArr, money.changeCalculator());
    }
    @Test
    public void changeCalculatorShouldNotReturnPennies() { //test that no pennies are returned or dollars
    Money money = new Money();
    BigDecimal moneyToReturn = new BigDecimal("5.37");
    money.addBalance(moneyToReturn);
    int[] changeArr = {21, 1 ,0};
    assertArrayEquals(changeArr, money.changeCalculator());
    }

    @Test
    public void testResetFunds() { //test funds reset to zero
        Money money = new Money();
        BigDecimal moneyToReset = new BigDecimal("5.0");
        money.addBalance(moneyToReset);
        money.resetFunds();
        assertEquals(BigDecimal.ZERO,money.getBalance());
    }
}
