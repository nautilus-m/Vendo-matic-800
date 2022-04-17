package com.techelevator;

import com.techelevator.view.VendingMachineVends;

import java.math.BigDecimal;

public class Drink extends VendingMachineVends {
    public Drink(String slotID, String itemName, BigDecimal itemPrice, String itemCategory) {
        super(slotID, itemName, itemPrice, itemCategory);
    }

    public Drink(String slotID, String itemCategory) {
        super(slotID, itemCategory);
    }

    @Override
    public String outputMessage() {
        return "Glug Glug, Yum!";
    }
}