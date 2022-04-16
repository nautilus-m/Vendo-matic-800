package com.techelevator.view;

public class Main {
    public static void main(String[] args) {

        MenuDisplay menuDisplay = new MenuDisplay();
        Inventory inventory = new Inventory();
        menuDisplay.firstUserMenu();
        inventory.updateInventory();
    }
}
