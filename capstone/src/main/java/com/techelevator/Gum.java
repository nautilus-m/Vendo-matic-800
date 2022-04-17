package com.techelevator;

import com.techelevator.view.VendingMachineVends;

import java.math.BigDecimal;

public class Gum extends VendingMachineVends {
    public Gum(String slotID, String itemName, BigDecimal itemPrice, String itemCategory) {
        super(slotID, itemName, itemPrice, itemCategory);
    }

    public Gum(String slotID, String itemName) {
    }


    @Override
    public String outputMessage() {
        return "Chew Chew, Yum!";
    }
}
