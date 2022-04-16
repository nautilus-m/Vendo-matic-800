package com.techelevator;

import com.techelevator.view.Menu;












/* public class VendingMachineCLI {

    private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
    private static final String[] MAIN_MENU_OPTIONS = {MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE};

    private Menu menu;

    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }

    public void run() {
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
                // display vending machine items
            } else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
                // do purchase
            }
        }
    }

    public static void main(String[] args) {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }
}
*/
//// MAIN MENU
// - runs at the start of the application
// - three options are presented in this menu
//   - Display Vending Machine Items
//   - Purchase
//   - Exit
// -


//// FIRST MENU
// - Output the contents of vending machine with remaining quantity
// Vending machine has a slot identifier and purchase price
// only has room for five items
// will be fully stock initially, indicates SOLD OUT when it sold out

//// SECOND MENU
// - shows a list of things to purchase
// - show what's available and allow them to enter an option
// - if option doesn't exist inform customer and return to purchase menu
// - if product is sold out, inform customer and return to purchase menu
// - if product selection is valid, dispense it to the customer.
// - after item is dispensed, print the item name, cost and money remaining
// - after dispensing, print messages to user
//   - chips: "Crunch Crunch Yum!"
//   - candy: "Munch Munch Yum!"
//   - drink: "Glug Glug Yum!"
//   - gum: "Chew Chew Yum!"
// - after dispensing, update machine's balance and return to the purchase menu


//// THIRD MENU
// "Finish Transaction"  give the customer the remaining change in nickels, dimes and quarters (use the least amount of coins )
// update the machine's current balance to show $0
// return to the main menu to use again

// ANTI-THEFT
// purchases must generate a line in a file called "Log.txt"
// follow the format in the readme

// TEST
// ask about the test during office hours

// OPTIONAL - Sales report
// - make a hidden option the main menu (4)
// - in this menu, show the total sales since the machine started (diagram in readme)
// -


