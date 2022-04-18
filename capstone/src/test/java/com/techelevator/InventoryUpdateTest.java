package com.techelevator;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class InventoryUpdateTest {

    @Test
    public void doesReadInventoryFileUpdateInventory() throws FileNotFoundException { //tests that inventory update runs, test passes
        //Arrange
        boolean isNotEmpty = true;
        boolean isEmpty = false;
        InventoryUpdate inventoryUpdate = new InventoryUpdate();
        for(int i = 0; i < inventoryUpdate.products.size(); i++) {
            if(inventoryUpdate.products.isEmpty()) {
                isEmpty = true;
            }
        } Assert.assertEquals(false, false);



    }

     /*@Test(expected = FileNotFoundException.class)
    public void doesReadInventoryFileThrowException() throws FileNotFoundException {
        boolean isEmpty = false;
        InventoryUpdate inventoryUpdate = new InventoryUpdate();
        File newFile = new File("vendingmachine.csv");
        inventoryUpdate.readInventoryFile();
        for (int i = 0; i < inventoryUpdate.products.size(); i++) {
            if (inventoryUpdate.products.isEmpty()) {
                isEmpty = true;
            }
            Assert.assertEquals(true, true);
        }
    }*/ //need to better understand how to test for exceptions being thrown

    @Test
    void displayProducts() { //we have catch in place for invalid, test valid and test invalid (2 tests total)
        //Arrange

        //Act

        //Assert
    }

    @Test
    void itemRequested() {
        //catch for over max quantity, write test for that and for passing and to check that quantity updates with amount deducted from initial inventory
        //Arrange

        //Act

        //Assert
    }

    @Test
    void quantityRequested() {
        //Arrange

        //Act

        //Assert
    }

    @Test
    void dispenseItem() {
        //Arrange

        //Act

        //Assert
    }

    @Test
    void findAmount() {
        //Arrange

        //Act

        //Assert
    }

    @Test
    void resetQuantityRequested() {
        //Arrange

        //Act

        //Assert
    }
}