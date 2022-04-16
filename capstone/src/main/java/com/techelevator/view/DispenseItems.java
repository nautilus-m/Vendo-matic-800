package com.techelevator.view;

import java.util.Scanner;

public class DispenseItems extends Item {
    Money money = new Money();
    Inventory inventory = new Inventory();

    public Money getMoney() {
        return money;
    }


    public void dispenseItem() {
        if (inventory.checkBalanceVsCost()) { //dispense happens once item is requested, in stock, and money available covers purchase price * how many requested
            //needs to run through items to see if selected item falls into right category for output message
            System.out.println("Crunch Crunch, Yum!");
            System.out.println("Munch Munch, Yum!");
            System.out.println("Glug Glug, Yum!");
            System.out.println("Chew Chew, Yum!");
            //update balance & output to user
            //if balance is >= 0.75 (lowest cost of item in stock - is there a way to check for this? maybe if balance.equals.item.getPrice?)
            //if true, call make another purchase method
            //if not, request user either submit more money, or get change back
            //if get change back, call dispenseChange method


        }  //add record of sale to our log

        //method to ask user if they would like to continue with making another purchase

    } public void makeAnotherPurchase() {
        System.out.println("Would like to continue with making another purchase? Please enter 2 for YES or 3 for NO: ");
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        String nextInput = scanner.nextLine();
        if(nextInput.equals("2")) {
            inventory.selectionMenu();
        }if(nextInput.equals("3")); // && if money tracker > 0,) {
        //dispense change so count resets to zero before next use
        System.out.println("Thanks for visiting the Vendomatic 800. Come back soon!");
        System.exit(0);
    }

}

