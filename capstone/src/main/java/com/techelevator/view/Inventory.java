package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Inventory extends Item {

    private List<Item> items = new ArrayList<>();
    private Map<String, Item> itemsByID = new HashMap<>();
    // private int  quantity = 5;


    public void updateInventory() {
        File inputFile = new File("capstone/vendingmachine.csv");
        try (Scanner inventoryList = new Scanner(inputFile)) {
            inventoryList.useDelimiter("|");
            //use hasNext because we need to check for another token AFTER the delimiter
            while (inventoryList.hasNext()) {
                String slotID = inventoryList.next();
                String itemName = inventoryList.next();
                double itemPrice = inventoryList.nextDouble();
                String itemCategory = inventoryList.next();
                Item item = new Item(slotID,itemName, itemPrice, itemCategory, 5); // should item and item ID not be associated because technically those could change? items.add(item); itemsByID.put(slotID, item); }} catch (FileNotFoundException e) {

            }
        } catch (FileNotFoundException e) {
            System.err.println("The file does not exist.");

        }
    } // the exception may need to change, but this should reflect reading the file, scanning for delimiter, reading each token after delimiter, and assigning it to the right datatype

    //so we can plug those data types into our list + map




    /*public int getQuantity() {
        return quantity;
    }*/
}



