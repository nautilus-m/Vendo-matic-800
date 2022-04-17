package com.techelevator;

import com.techelevator.view.VendingMachineVends;

import java.math.BigDecimal;

public class Chip extends VendingMachineVends {
    public Chip(String slotID, String itemName, BigDecimal itemPrice, String itemCategory) {
        super(slotID, itemName, itemPrice, itemCategory);

    }

    public Chip(String slotID, String itemCategory) {
        super(slotID, itemCategory);
    }

    @Override
    public String outputMessage() {
        return "Crunch Crunch, Yum!";
    }
}

