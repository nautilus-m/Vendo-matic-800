package com.techelevator.view;

public class Item {
    // Instance variables
    private String slotID;
    private String itemName;
    private double itemPrice;
    private String itemCategory;
    private int  quantity = 5;
    // Constructors
    public Item(String slotID, String itemName, double itemPrice, String itemCategory, int quantity ) {
        this.slotID = slotID;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCategory = itemCategory;
        this.quantity = quantity;
    }

    public Item() {

    }

    // Methods

    // Getters and setters

    public String getSlotID() {
        return slotID;
    }

    public void setSlotID(String slotID) {
        this.slotID = slotID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
