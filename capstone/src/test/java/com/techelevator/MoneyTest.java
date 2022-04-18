package com.techelevator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    @BeforeEach


    @Test
    void purchaseIsCoveredShouldReturnFalse() { // WIP
        Money money = new Money();
        BigDecimal bigDecimal = new BigDecimal("");

       assertTrue(money.purchaseIsCovered(bigDecimal));
    }
    @Test
    void purchaseIsCoveredShouldReturnTrue() { //make sure returns only false if less than zero, write test to pass (2 tests)

    }

    @Test
    public void testBalanceDeduct() { //test that method does not add to balance, test that it works (2 tests)
    }

    @Test
    public void testFeedMoney() {//test exception thrown and exception passed (2 tests)
    }

    @Test
    public void testFeedMeMoreMONEY() { //test that it updates balance & accepts money
    }

    @Test
    public void testChangeCalculator() { //test that output is correct, test that no pennies are returned or dollars (2 tests)
    }

    @Test
    public void testResetFunds() { //test funds reset to zero
    }
}
