package com.techelevator;

import com.techelevator.view.VendingMachineVends;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class InventoryUpdate {
    List<VendingMachineVends> products = new ArrayList<>();
    Map<String, Integer> productQuantityUpdate = new HashMap<>();
    int quanReq;
    String itemRequested;
    private BigDecimal amount = new BigDecimal(0.00);

    File file;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getQuanReq() {
        return quanReq;
    }

    public void setQuanReq(int quanReq) {
        this.quanReq = quanReq;
    }

    public String getItemRequested() {
        return itemRequested;
    }

    public void setItemRequested(String itemRequested) {
        this.itemRequested = itemRequested;
    }

    public Map<String, Integer> getProductQuantityUpdate() {
        return productQuantityUpdate;
    }

    public void setProductQuantityUpdate(Map<String, Integer> productQuantityUpdate) {
        this.productQuantityUpdate = productQuantityUpdate;
    }

    public List<VendingMachineVends> getProducts() {
        return products;
    }

    public void setProducts(List<VendingMachineVends> products) {
        this.products = products;
    }

    public InventoryUpdate() {
    }


    public File getFile() {
        return file;
    }

    public List<VendingMachineVends> readInventoryFile() throws FileNotFoundException { //exception to handle if our file already existed
        this.file = new File("vendingmachine.csv"); //need to look at this not being hardcoded
        if (!this.file.exists()) {
            throw new FileNotFoundException();
        }
        try (Scanner inventoryList = new Scanner(this.file)) {
            while (inventoryList.hasNext()) { //use hasNext because we need to check for another token AFTER the delimiter
                String line = inventoryList.nextLine();
                String[] lineArr = line.split("\\|"); // needed to use regex to get it to catch the delimiter
                String slotID = lineArr[0]; //passing slotID to array
                String itemName = lineArr[1]; //passing itemName
                BigDecimal itemPrice = new BigDecimal(lineArr[2]); //using big decimal to set our price to format correctly
                String itemCategory = lineArr[3]; //what type of item passed to array
                VendingMachineVends item = null; // starts us with a null item
                if (itemCategory.equals("Chip")) {
                    item = new Chip(slotID, itemName, itemPrice, itemCategory); //creates a new item if category matches the parameter in conditional statement using constructor in that class
                } else if (itemCategory.equals("Candy")) {
                    item = new Candy(slotID, itemName, itemPrice, itemCategory);
                } else if (itemCategory.equals("Drink")) {
                    item = new Drink(slotID, itemName, itemPrice, itemCategory);
                } else if (itemCategory.equals("Gum")) {
                    item = new Gum(slotID, itemName, itemPrice, itemCategory);
                }
                products.add(item); //adding our created item to our product list
            }
                Log.writeToAuditLog("INVENTORY UPDATED"); //writes update to log
        } catch (FileNotFoundException e) {
            System.err.println("The file does not exist.");
        }
        return products; //returns the list
    }

    public String displayProducts() {
        String display = "";
        for (VendingMachineVends product : products) {
            display += product.getSlotID() + "|" + product.getItemName() + ", $" + product.getItemPrice() + "\n" + "Available: " + product.getQuantity() +" ";
        } return display;
    }

    public String itemRequested() { //holds slot ID for item to be purchased
        boolean isItemValid = false;
        itemRequested = "";
        Scanner scanner = new Scanner(System.in);
        String item = scanner.nextLine();
        for (VendingMachineVends product : products) {
            if (product.getSlotID().equals(item)) {
                itemRequested += item;
                Log.writeToAuditLog("Slot ID of product requested: " + this.itemRequested.toUpperCase(Locale.ROOT));
                isItemValid = true;
            }
        } if (!isItemValid) {
            System.err.println("Please enter a valid slot ID ");
            itemRequested();
        }

        return this.itemRequested;

    }

    public int quantityRequested() { //takes in # of items desired
        int maxRequest = 5;
        Scanner scanner = new Scanner(System.in);
        int requested = scanner.nextInt();
        for (VendingMachineVends quantity : products) {
            if (quantity.getSlotID().equals(itemRequested)) {
                quanReq += requested;
                Log.writeToAuditLog("Amount of items requested by user: " + this.quanReq);
                if(quanReq > maxRequest || quanReq > quantity.getQuantity()) { //quantity requested cannot exceed amount in machine
                    System.out.println("The amount you are trying to purchase exceeds the available inventory."
                    + "\n" + "The available amount is only: " + quantity.getQuantity());
                    Log.writeToAuditLog("Amount of items requested by user exceeded available inventory of " + quantity.getQuantity());
                    resetQuantityRequested(); //resets count to zero
                    System.out.println("Please enter amount you wish to purchase: ");
                    quantityRequested(); //returns user the option to enter a new amount
                }
            }
        }
        return this.quanReq;
    }

    public void dispenseItem() { //uses item category as reference to find right item + quantity, subtracts quanReq amount from quantity of product, outputs item message
        for (VendingMachineVends product : products) {
            if (product.getSlotID().equals(itemRequested)) {
                productQuantityUpdate.put(itemRequested, product.getQuantity() - quanReq);
                if(product.getItemCategory().equalsIgnoreCase("Chip")) {
                    Chip chip = new Chip(product.getSlotID(), product.getItemName());
                    System.out.println(chip.outputMessage()); //this outputs correct item message
                } else if(product.getItemCategory().equalsIgnoreCase("Drink")) {
                    Drink drink = new Drink(product.getSlotID(), product.getItemName());
                    System.out.println(drink.outputMessage());
                } else if(product.getItemCategory().equalsIgnoreCase("Candy")){
                    Candy candy = new Candy(product.getSlotID(), product.getItemName());
                    System.out.println(candy.outputMessage());
                } else if(product.getItemCategory().equalsIgnoreCase("Gum")) {
                    Gum gum = new Gum(product.getSlotID(), product.getItemName());
                    System.out.println(gum.outputMessage());
                }
                for (Map.Entry<String, Integer> map : productQuantityUpdate.entrySet()) {

                    System.out.println("Item dispensed:  " + product.getItemName() + "\n" + "Quantity dispensed: " + this.quanReq + "| Remaining in machine: " + map.getValue());
                    Log.writeToAuditLog("Item dispensed: " + product.getItemName().toUpperCase(Locale.ROOT) + " | Quantity dispensed: " + this.quanReq);
                    Log.writeToAuditLog("Current inventory of item purchased: " + map.getValue());
                }
            }
        }
    }
    public BigDecimal findAmount() {
        for (VendingMachineVends price : products) {
            if (itemRequested.equals(price.getSlotID())) {
                amount = BigDecimal.valueOf(quanReq).multiply(price.getItemPrice());
            }
        } return this.amount;
    }
    public void resetQuantityRequested() {
        this.quanReq = 0;
    }

}