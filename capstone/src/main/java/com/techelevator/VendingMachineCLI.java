package com.techelevator;

import com.techelevator.view.Menu;
import com.techelevator.view.VendingMachineVends;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

public class VendingMachineCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String MAIN_MENU_OPTION_EXIT = "Exit";
    private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT};
    private Menu menu;
    InventoryUpdate inventoryUpdate = new InventoryUpdate();
    Money money = new Money();



    public static void main(String[] args) throws FileNotFoundException {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();

    }

    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }

    public void run() throws FileNotFoundException {
        inventoryUpdate.readInventoryFile(); //should only run at start of program
        System.out.println("************** Welcome to the VENDO-MATIC 800 **********" +
                "\n Please choose from the following menu options: ");
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
            //inventoryUpdate.findAmount();
            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                inventoryUpdate.displayProducts(); // displays vending machine items
                System.out.println("Please select 2 to PURCHASE or 3 to EXIT >>>>> ");
            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                money.feedMoney(); //take in money
                System.out.println("Please enter the 2 character slot ID of the item you wish to purchase: "); //take in purchase request (requested slotID)
                inventoryUpdate.itemRequested(); //dispense using id from this /WORKS
                System.out.println(inventoryUpdate.getItemRequested());
                System.out.println("Please enter the amount you wish to purchase : "); //get how many they want
                inventoryUpdate.quantityRequested(); //WORKS
                System.out.println(inventoryUpdate.getQuanReq()); //will delete this cmd when done
                money.purchaseIsCovered(inventoryUpdate.getAmount()); //if it is true, we need to dispense the item with the right message, run the deduct balance method, update quantities of items purchased
                if(!money.purchaseIsCovered(inventoryUpdate.getAmount())){ //not currently checking funds correctly
                    System.out.println("Insufficient funds! Please enter additional funds to continue: ");
                    money.feedMoney();
                } else {
                    inventoryUpdate.findAmount();//cost to customer;
                    System.out.println("Total cost of items: " + inventoryUpdate.getAmount());
                    inventoryUpdate.dispenseItem(); //deducts selected quantity from remaining items, outputs message for item to user;
                    money.balanceDeduct(inventoryUpdate.getAmount()); //updating balance with transaction amount;
                    System.out.println("Balance remaining in machine: " + money.getBalance()); //balance after cost;
                    System.out.println("If you would like to make another purchase, please choose 2 for YES or 3 for EXIT: "); //offer to make another purchase if money is still the machine
                    Scanner scanner = new Scanner(System.in);
                    String nextUserChoice = scanner.nextLine();
                    if(nextUserChoice.equals("2")) {
                        returnToPurchase(); //this successfully returns user to purchase menu without losing balance still in machine, adds the new money to the bal existing, and does not update inv.
                    } else if (nextUserChoice.equals("3")) { //if not, provide change back and exit
                        money.changeCalculator(); //run change back method, provides change dispensed output to user
                        money.resetFunds();
                        Log.writeToAuditLog("Balance in machine after change dispensed: " + money.getBalance());
                        exit();
                    }
                }
            } else if (choice.equals(MAIN_MENU_OPTION_EXIT)) {
                exit();

            }
        }
    }
    public void returnToPurchase() {
        money.feedMoney(); //take in money
        money.addBalance(money.getBalance()); //updates balance with additional funds
        System.out.println("Please enter the 2 character slot ID of the item you wish to purchase: "); //take in purchase request (requested slotID)
        inventoryUpdate.itemRequested(); //dispense using id from this /WORKS
        System.out.println(inventoryUpdate.getItemRequested());
        System.out.println("Please enter the amount you wish to purchase : "); //get how many they want
        inventoryUpdate.quantityRequested(); //WORKS
        System.out.println(inventoryUpdate.getQuanReq()); //will delete this cmd when done
        money.purchaseIsCovered(inventoryUpdate.getAmount()); //if it is true, we need to dispense the item with the right message, run the deduct balance method, update quantities of items purchased
        if (!money.purchaseIsCovered(inventoryUpdate.getAmount())) { //not currently checking funds correctly
            System.out.println("Insufficient funds! Please enter additional funds to continue: ");
            completePurchase();
        } else {
            inventoryUpdate.findAmount();//cost to customer;
            System.out.println("Total cost of items: " + inventoryUpdate.getAmount());
            inventoryUpdate.dispenseItem(); //deducts selected quantity from remaining items, outputs message for item to user;
            money.balanceDeduct(inventoryUpdate.getAmount()); //updating balance with transaction amount;
            System.out.println("Balance remaining in machine: " + money.getBalance()); //balance after cost;
            System.out.println("If you would like to make another purchase, please choose 2 for YES or 3 for EXIT: "); //offer to make another purchase if money is still the machine
            Scanner scanner = new Scanner(System.in);
            String nextUserChoice = scanner.nextLine();
            if (nextUserChoice.equals("2")) {
                returnToPurchase();
            } else if (nextUserChoice.equals("3")) { //if not, provide change back and exit
                money.changeCalculator(); //run change back method, provides change dispensed output to user
                money.resetFunds();
                Log.writeToAuditLog("Balance in machine after change dispensed: " + money.getBalance());
                exit();
            }
        }
    }
    public void completePurchase() {
        System.out.println("Please enter the amount you wish to purchase : "); //get how many they want
        inventoryUpdate.quantityRequested(); //WORKS
        inventoryUpdate.findAmount();//cost to customer;
        System.out.println("Total cost of items: " + inventoryUpdate.getAmount());
        inventoryUpdate.dispenseItem(); //deducts selected quantity from remaining items, outputs message for item to user;
        money.balanceDeduct(inventoryUpdate.getAmount()); //updating balance with transaction amount;
        System.out.println("Balance remaining in machine: " + money.getBalance()); //balance after cost;
        System.out.println("If you would like to make another purchase, please choose 2 for YES or 3 for EXIT: "); //offer to make another purchase if money is still the machine
        Scanner scanner = new Scanner(System.in);
        String nextUserChoice = scanner.nextLine();
        if(nextUserChoice.equals("2")) {
            returnToPurchase(); //this successfully returns user to purchase menu without losing balance still in machine, adds the new money to the bal existing, and does not update inv.
        } else if (nextUserChoice.equals("3")) { //if not, provide change back and exit
            money.changeCalculator(); //run change back method, provides change dispensed output to user
            money.resetFunds();
            Log.writeToAuditLog("Balance in machine after change dispensed: " + money.getBalance());
            exit();
        }
    }
    public void exit () {
        System.out.println("Thanks for visiting the Vendomatic 800. Come back soon!");
        System.exit(0);
    }




}
