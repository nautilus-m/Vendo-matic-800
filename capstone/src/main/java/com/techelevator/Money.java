package com.techelevator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Money {
    private BigDecimal balance = new BigDecimal(0.0);

    public void addBalance(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public boolean purchaseIsCovered(BigDecimal amount) { //if balance is greater than or equal to 0, purchase is covered by funds in machine
        BigDecimal comparison = this.balance.subtract(amount);
        if (comparison.intValue() < 0) {
            Log.writeToAuditLog("User entered insufficient funds for purchase.");
            return false;
        }

        return true;
    }

    public void balanceDeduct(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
        Log.writeToAuditLog("Balance remaining after transaction by customer: " + this.balance);
    }

    public boolean feedMoney() { //takes money input, checks to see if valid dollar is correct
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter dollar bills to continue" + " (bills accepted are $1, $2, $5, $10, & $20)");
            String input = scanner.nextLine();
            double moneyReceived = Double.parseDouble(input);
            double[] billArr = new double[]{1.00, 2.00, 5.00, 10.00, 20.00};
            for (double bill : billArr) {
                if (bill == moneyReceived) {
                    addBalance(BigDecimal.valueOf(moneyReceived));
                    System.out.println("Money in machine: " + this.balance);
                    Log.writeToAuditLog("Money Received:" + this.balance);
                    return true;
                }
            }
            System.out.println("Error. Please enter valid dollar amount: "); //out message saying if money was not accepted
            feedMoney();
        } catch (NumberFormatException nfe) {
            System.err.println("Foreign Object in slot!");
            feedMoney();
        }

        return false;
    }

    public boolean feedMeMoreMONEY(BigDecimal amount) {
        if(feedMoney()) {
            if(!purchaseIsCovered(amount)) {
                return false;
            }
        } return true;
    }

    public int[] changeCalculator() {
        int[] changeArr = new int[3]; //we return only 3 types of coins
        int quartersBack;
        int dimesBack;
        int nickelsBack;
        int balanceCents = this.balance.multiply(new BigDecimal(100)).setScale(2, RoundingMode.HALF_UP).intValueExact();
        //math to build our change
        quartersBack = balanceCents / 25;
        changeArr[0] = quartersBack;
        balanceCents = balanceCents - (quartersBack * 25);

        dimesBack = balanceCents / 10;
        changeArr[1] = dimesBack;
        balanceCents = balanceCents - (dimesBack * 10);

        nickelsBack = balanceCents / 5;
        changeArr[2] = nickelsBack;

        System.out.println("Change Dispensing: " +
                "\n" + "Quarters: " + changeArr[0] +
                " Dimes: " + changeArr[1] + " Nickels: " + changeArr[2]);
        Log.writeToAuditLog("Change dispensed to user: " +
                "Quarters: " + changeArr[0] + " Dimes: " +
                changeArr[1] + " Nickels: " + changeArr[2]);

        return changeArr;
    }

    public void resetFunds() {
        this.balance = BigDecimal.ZERO;
    }

    @Override
    public String toString() {
        return "Current Balance: $" + this.balance;
    }


}
