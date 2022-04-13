package com.techelevator.view;

import java.util.Scanner;

public class Money extends MoneyAccepted {
    private double moneyTracker = 0;
    private double changeBack;
    Scanner scanner = new Scanner(System.in);

    public void depositMoney() {
        double moneyReceived = scanner.nextDouble();
        System.out.println("Please enter dollar bills to continue (bills accepted are $1, $2, $5, $10, & $20)");
        if (moneyReceived <= billsAccepted.TWENTY_DOLLAR.getBillValue()) {
            if (moneyReceived == billsAccepted.TWENTY_DOLLAR.getBillValue()) {
                moneyTracker += moneyReceived;
            } else if (moneyReceived <= billsAccepted.TEN_DOLLAR.getBillValue()) {
                moneyTracker += moneyReceived;
            } else if (moneyReceived <= billsAccepted.FIVE_DOLLAR.getBillValue()) {
                moneyTracker += moneyReceived;
            } else if (moneyReceived <= billsAccepted.TWO_DOLLAR.getBillValue()) {
                moneyTracker += moneyReceived;
            } else if (moneyReceived == billsAccepted.ONE_DOLLAR.getBillValue()) {
                moneyTracker += moneyReceived;
            }
        } else {
            System.out.println("Please enter a valid dollar amount.");
        }
    }
    public void changeBack() {
        Item item = new Item();
        changeBack = moneyTracker - item.getItemPrice();


    }
}
