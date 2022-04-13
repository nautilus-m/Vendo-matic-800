package com.techelevator.view;

import java.util.Scanner;

public class MenuDisplay {
    public void firstUserMenu() {

        System.out.println("************** Welcome to the VENDO-MATIC 800 **********" + "\n Please choose from the following menu options: " +
                "\n(1) Display Vending Machine Items \n(2) Purchase \n (3) Exit");
        Scanner scanner = new Scanner(System.in);
        String firstUserChoice = scanner.nextLine();
        if (firstUserChoice.equals("1"))  //changed from contains to equals so that we can confirm number only is inputted


        System.out.println("Here is where we grab our method that prints a menu from the file we read");
        System.out.println(inventoryMenu());
        System.out.println("Need to probably tell the user to choose either 2 or 3");
        String firstSubMenuChoice = scanner.nextLine();
        if(firstSubMenuChoice.equals("2")) {
            //direct to purchase menu
        } else {
            System.exit(0);
    } if(firstUserChoice.equals("2")) { // parse string to int to update money recv'd variable
        System.out.println("here is where we grab our method that directs to purchase menu");
        System.out.println("Please enter dollar bills to continue (bills accepted are $1, $2, $5, $10, & $20)");
    }if(firstUserChoice.equals("3")) {
        System.out.println("\nThanks for visiting the Vendomatic 800. Come back soon!");
        System.exit(0);
    } else {

        System.err.println("Error. Please enter a valid menu option.");
    }
        }

        public void purchaseMenu() {
        // check if item exist, is in stock, and the quantity is available, is the money valid.
            // update the quantity after valid purchase
    }

    public void exit() {
        System.exit(0);
    }

}
