package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Inventory extends Item {

    private List<Item> items = new ArrayList<>();
    private Map<String, String> itemsByID = new HashMap<>();
    private Map<String, Integer> inventoryCount = new HashMap<>();
    private String request;
    private int quantityRequested;
    private boolean balanceVsCost;
    private double cost;
    // private int  quantity = 5;


    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Map<String, String> getItemsByID() {
        return itemsByID;
    }

    public void setItemsByID(Map<String, String> itemsByID) {
        this.itemsByID = itemsByID;
    }

    public Map<String, Integer> getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(Map<String, Integer> inventoryCount) {
        this.inventoryCount = inventoryCount;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public int getQuantityRequested() {
        return quantityRequested;
    }

    public void setQuantityRequested(int quantityRequested) {
        this.quantityRequested = quantityRequested;
    }

    public boolean isBalanceVsCost() {
        return balanceVsCost;
    }

    public void setBalanceVsCost(boolean balanceVsCost) {
        this.balanceVsCost = balanceVsCost;
    }

    public void updateInventory() {
        File inputFile = new File("C:\\Users\\flame\\Desktop\\Repos\\module-1-capstone\\capstone\\vendingmachine.csv");
        try (Scanner inventoryList = new Scanner(inputFile)) {
            //use hasNext because we need to check for another token AFTER the delimiter
            while (inventoryList.hasNext()) {
                inventoryList.useDelimiter("\\|"); // needed to use regex to get it to catch the delimiter
                String slotID = inventoryList.next();
                String itemName = inventoryList.next();
                String itemPrice = inventoryList.next();
                String itemCategory = inventoryList.nextLine().trim().replaceAll("\\r|\\n|\\|", ""); // each line in the file ends with \r & \n

                items.add(new Item(slotID, itemName, itemPrice, itemCategory, getQuantity()));
                itemsByID.put(slotID, itemName); // may need to adjust this in our purchase method } } catch (FileNotFoundException e) { // should close our file
                inventoryCount.put(itemName, inventoryCount.getOrDefault(itemName, getQuantity()));

            }


       } catch (FileNotFoundException e) {
           System.err.println("The file does not exist.");
//
       }
        } // the exception may need to change, but this should reflect reading the file, scanning for delimiter, reading each token after delimiter, and assigning it to the right datatype

        //so we can plug those data types into our list + map



    public void inventoryMenu() {
        for(Item item : items) {
            System.out.println(item.getItemName() + ", $" + item.getItemPrice() + "\n" + "Available: " + getQuantity());
        }

    }


    public void selectionMenu() {
        for(Map.Entry<String, String> map : itemsByID.entrySet()) {

            System.out.println(map.getKey() + ", " + map.getValue());
        }
    }
    public void deduct() {// need this method to deduct quantity purchased from inventory quantity
        int count = inventoryCount.get(getItemName());
        inventoryCount.put(getItemName(), count - this.quantityRequested); // minus by how many purchased /quantity requested
    }

    public boolean checkBalanceVsCost() { //method to tell user how much total request costs & check against balance to see if it is available
        //can be run with every purchase to confirm money available
        Money money = new Money();
        double price = 0;
        for (Item item : items) {
            if (item.getItemPrice() != null) {
                this.cost += Double.parseDouble(item.getItemPrice()) * this.getQuantityRequested();
                if (this.cost <= money.getMoneyTracker()) {
                    balanceVsCost = true;
                }

            }
        } return false;
    }




    public void checkSelection() { //checks user input against key values in Map to verify selection is valid
        Scanner scanner = new Scanner(System.in);
        this.request = scanner.nextLine();
        if (!itemsByID.containsKey(this.request)) { //need to find a way to ignore case of entry
            System.out.println("The ID you entered does not match any of the items listed. Please enter a valid slot ID.");
            String secondAttemptToPurchase = scanner.nextLine(); //allows a max of 2 failed attempts before redirecting to user menu / need to make sure we don't reset count + money unless exit processed
            if (!itemsByID.containsKey(secondAttemptToPurchase)) {
                System.out.println("Second attempt to purchase has failed, please review the menu once more." + "\n");
                MenuDisplay menuDisplay = new MenuDisplay();
                menuDisplay.firstUserMenu();
            }
        }
        request = this.request;


    }
    public void checkQuantity() { //checks that there is enough inventory in the machine to proceed to purchase
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the amount you would like to purchase: ");
        quantityRequested = scanner.nextInt();
        for (Map.Entry<String, String> idMap : itemsByID.entrySet()) {
            if (idMap.getKey().equals(request)) {
                int quantityAvail = inventoryCount.get(idMap.getValue()); //by comparing the two maps, we can pull the inventory count for the right item using the slot ID
                if (quantityAvail >= quantityRequested) {
                    System.out.println("Great choice!");
                } else {
                    System.out.println("This item is unavailable to purchase in the requested quantity. This machine contains only " + quantityAvail + ". Please select that amount or less.");
                    checkQuantity();
                }
            }
            this.quantityRequested = quantityRequested;
        }
    }









}



