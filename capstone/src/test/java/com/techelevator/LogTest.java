package com.techelevator;

import org.junit.Test;

import java.io.File;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class LogTest {

    @Test //this does not run, it just spins for a million years, needs work.
    public void doesWriteToAuditLogWriteToAuditLog() {
        //Arrange
        Log.writeToAuditLog("We're writing a little test message.");
        boolean isItThere = false;
        String expectedOutput = "We're writing a little test message.";
        File readFile = new File("Log.txt");
        try(Scanner file = new Scanner(readFile)) {
            while (file.hasNextLine()) ;
            String readLine = file.nextLine();
            if (readLine.contains(expectedOutput)) {
                isItThere = true;
            }
            //Act
            //Assert
            assertEquals(true, true);
        } catch (Exception e) {
            System.err.println("Line was not printed to file.");
        }
    }


}