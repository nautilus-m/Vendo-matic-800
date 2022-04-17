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
    void purchaseIsCoveredShouldReturnTrue() {

    }

}