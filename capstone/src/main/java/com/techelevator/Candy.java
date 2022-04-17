package com.techelevator;

import com.techelevator.view.VendingMachineVends;

import java.math.BigDecimal;

    public class Candy extends VendingMachineVends {

        public Candy(String slotID, String itemName, BigDecimal itemPrice, String itemCategory) {
            super(slotID, itemName, itemPrice, itemCategory);
        }

        public Candy(String slotID, String itemName) {
        }

        @Override
        public String outputMessage() {
            return "Munch Munch, Yum!";
        }
    }

