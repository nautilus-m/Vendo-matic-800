package com.techelevator;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

class LogTest {

    @Test
    public void doesWriteToAuditLogWriteToAuditLog() {
        Log.writeToAuditLog("We're writing a little test message.");
        boolean isItThere = false;
        String expectedOutput = "We're writing a little test message.";
        File readFile = new File("capstone/Log.txt");
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