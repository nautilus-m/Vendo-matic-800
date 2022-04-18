package com.techelevator.view;

import java.math.BigDecimal;

public abstract class VendingMachineVends {
    private String slotID;
    private String itemName;
    private BigDecimal itemPrice;
    private String itemCategory;
    private int quantity; // should always start at 5

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

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
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

    public VendingMachineVends(String slotID, String itemName, BigDecimal itemPrice, String itemCategory) {
        this.slotID = slotID;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCategory = itemCategory;
        this.quantity = 5; //setting starting quantity to be 5
    }

    public VendingMachineVends(String slotID, String itemCategory) {
        this.slotID = slotID;
        this.itemCategory = itemCategory;
    }

    public VendingMachineVends() {

    }

    public abstract String outputMessage();

    @Override
    public String toString() {
        return this.slotID + "|" + this.itemPrice + "|" + this.quantity + "|" + this.itemName ;
    }

}
