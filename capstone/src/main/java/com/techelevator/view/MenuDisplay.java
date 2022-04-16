package com.techelevator.view;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MenuDisplay extends Inventory { //will display output to user and accept input, and call methods accordingly
        Inventory inventory = new Inventory();
        Money money = new Money();
        Item item = new Item();
        DispenseItems dispenseItems = new DispenseItems();
        DecimalFormat decimalFormat = new DecimalFormat("$0.00");
        Scanner scanner = new Scanner(System.in);
    public void mainMenu() { /* renamed firstUserMenu to MainMenu */
        inventory.updateInventory(); // need to figure out how to get this to run at the same time in the main

        System.out.println("************** Welcome to the VENDO-MATIC 800 **********" +
                "\n Please choose from the following menu options: " +
                "\n(1) Display Vending Machine Items \n(2) Purchase \n(3) Exit");
        String userInput = scanner.nextLine();

        if(userInput.equals("1")){ //changed from contains to .equals() so that we can confirm exact required input is provided
            System.out.println("****ALL AVAILABLE ITEMS: ****");
            inventory.inventoryMenu();
            System.out.println("Please select '2' to proceed to purchase, or '3' to exit.");

            userInput = scanner.nextLine();

            if(userInput.equals("2")) {
                money.depositMoney();//accepts user input, checks to see if money is valid, updates money tracker -- need to get input to method
                inventory.selectionMenu(); //displays map of slotIDs + name of item
                total();
               // System.out.println("Please enter the two character slot identifier of the item you wish to purchase: ");
                inventory.checkSelection();//checks that entry is valid
                inventory.checkQuantity(); //checks requested amount of item is available
                inventory.checkBalanceVsCost();

                if(inventory.checkBalanceVsCost()) {
                    dispenseItems.dispenseItem();
                    //inventory.deduct();
                } else {
                    insufficientFunds();
                }
            } else {
                exit();
            }
        } if(userInput.equals("2")) {
            purchaseMenu();

        }if(userInput.equals("3")) {
            exit();
//        } else {
//            System.err.println("Error. Please enter a valid menu option.");
//            System.exit(0); // return to the first menu
//            //mainMenu();
        }
    }
    public void exit() {
        System.out.println("Thanks for visiting the Vendomatic 800. Come back soon!");
        System.exit(0);
    }

    public void total() {
        System.out.println("\nMoney received: " + decimalFormat.format(money.getMoneyTracker()));
    }

    public void insufficientFunds() {
        System.out.println("Looks like you need to insert more funds for that item." +
                " Would you like to continue? Please select 2 for YES, 3 for NO: ");
        String needsFundsInput = scanner.nextLine();
        if(needsFundsInput.equals("2")) {
            money.depositMoney();
        } else {
            //toPurchase.changeBack();
            exit();
        }

    }
    public void purchaseMenu() {
        money.depositMoney();//accepts user input, checks to see if money is valid, updates money tracker -- need to get input to method
        inventory.selectionMenu(); //displays map of slotIDs + name of item
        total();
        // System.out.println("Please enter the two character slot identifier of the item you wish to purchase: ");
        inventory.checkSelection();//checks that entry is valid
        inventory.checkQuantity(); //checks requested amount of item is available
        inventory.checkBalanceVsCost();

        if(inventory.checkBalanceVsCost()) {
            //dispenseItems.dispenseItem();
            //inventory.deduct();
        }
//        money.depositMoney();//accepts user input, checks to see if money is valid, updates money tracker which is then displayed
//        total();
//        inventory.selectionMenu(); //displays map of slotIDs + name of item
//        inventory.checkSelection();//checks that entry is valid
//        inventory.checkQuantity(); //checks requested amount of item is available
//        inventory.checkBalanceVsCost(); //method checking money recv'd covers cost of request item + quantity of item requested
//        //inventory.deduct();
//        //run purchase method
//        //run dispense method which executes sales log and displays output message
//        //topurchase method updating money log minus sales so far should run either in the dispense method or here
    }

}














