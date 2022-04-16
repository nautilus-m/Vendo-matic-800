package com.techelevator.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Money extends MoneyAccepted {
    private double moneyTracker = 0;
    private double changeBack;
    Scanner scanner = new Scanner(System.in);

    public double getMoneyTracker() {
        return moneyTracker;
    }

    public void setMoneyTracker(double moneyTracker) {
        this.moneyTracker = moneyTracker;
    }

    public double getChangeBack() {
        return changeBack;
    }

    public void setChangeBack(double changeBack) {
        this.changeBack = changeBack;
    }

    public Money() {

    }

    public void depositMoney() {
        System.out.println("Please enter dollar bills to continue" +
                " (bills accepted are $1, $2, $5, $10, & $20)");
        String input = scanner.nextLine();
        double moneyReceived = Double.parseDouble(input);
        if (moneyReceived <= billsAccepted.TWENTY_DOLLAR.getBillValue() ) {
            if (moneyReceived == billsAccepted.TWENTY_DOLLAR.getBillValue()) {
                moneyTracker += moneyReceived;
            } else if (moneyReceived == billsAccepted.TEN_DOLLAR.getBillValue()) {
                moneyTracker += moneyReceived;
            } else if (moneyReceived == billsAccepted.FIVE_DOLLAR.getBillValue()) {
                moneyTracker += moneyReceived;
            } else if (moneyReceived == billsAccepted.TWO_DOLLAR.getBillValue()) {
                moneyTracker += moneyReceived;
            } else if (moneyReceived == billsAccepted.ONE_DOLLAR.getBillValue()) {
                moneyTracker += moneyReceived;
            }
            Log.log("MONEY RECEIVED:");
        } else {
            System.out.println("Please enter a valid dollar amount.");
        }
    }


    public void changeBack() {
        Map<String, Integer> coinMap = new HashMap<>();
        //coinMap.put("Quarters" , 0);
        //coinMap.put("Dimes" , 0);
        //coinMap.put("Nickles" , 0);
        Item item = new Item();
        changeBack = moneyTracker - Double.parseDouble(item.getItemPrice());
        while (changeBack != 0) {
            if (changeBack - changeAccepted.QUARTERS.getCoinValue() <= changeBack) {
                changeBack = changeBack - changeAccepted.QUARTERS.getCoinValue();
                coinMap.put("Quarters", coinMap.get("Quarters") + 1);

            } else if (changeBack - changeAccepted.DIMES.getCoinValue() <= changeBack) {
                changeBack = changeBack - changeAccepted.DIMES.getCoinValue();
                coinMap.put("Dimes", coinMap.get("Dimes") + 1);

            } else if (changeBack - changeAccepted.NICKELS.getCoinValue() <= changeBack) {
                changeBack = changeBack - changeAccepted.NICKELS.getCoinValue();
                coinMap.put("Nickels", coinMap.get("Nickels") + 1);

            }
            for (Map.Entry<String, Integer> coin : coinMap.entrySet()) {
                System.out.println(coin.getKey() + coin.getValue());
            }
// subtract quarter value from change accepted

// add quarter to either a map or a method scoped variable

// we would do the same type of conditional for the lesser coins.

// sysout quarters, dimes, nickels

        }
    }

    public boolean isPurchasable(Item item) {
        Inventory inventory = new Inventory();
        System.out.println("Please enter the two character slot identifier of the item you wish to purchase: ");
        String itemToPurchase = scanner.nextLine();
        if (item.getSlotID().equals(itemToPurchase)) {
            System.out.println("The ID you entered does not match any of the items listed. Please enter a valid slot ID.");
        } else {
            System.out.println("Please enter how many you would like to purchase: ");
            int quantityRequested = scanner.nextInt();
            if (item.getQuantity() > 5 && item.getQuantity() >= quantityRequested) {
                //return true to run deduct method

            } else {
                System.out.println("This item is unavailable to purchase in the requested quantity. This machine contains only " + item.getQuantity() + ". Please select that amount or less.");

            }
            return true;
        }
        return false; // remove if having problems
    }
}