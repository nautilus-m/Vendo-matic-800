package com.techelevator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {
    @BeforeEach


    @Test
    void purchaseIsCoveredShouldReturnTrue() { //make sure returns only false if less than zero, write test to pass (2 tests)

    }

    @Test
    public void testBalanceDeduct() { //test that method does not add to balance, test that it works (2 tests)
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
    public void testFeedMoneyExeption() {//test exception thrown and exception passed (2 tests)


        assertThrows(NumberFormatException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Money money = new Money();
                String testInput = "TEST";
                InputStream in = new ByteArrayInputStream(testInput.getBytes(StandardCharsets.UTF_8));
                System.setIn(in);
                money.feedMoney();
            }
        });
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
