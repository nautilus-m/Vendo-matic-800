package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {

    public static void writeToAuditLog(String message){ //will print to log file with date and time stamp for every transaction when called
        try {
            String timeStamp = generateDateTimeStamp();
            message = " " + timeStamp + " " + message + "\n";
            PrintWriter printWriter = new PrintWriter(new FileOutputStream("capstone/Log.txt", true));
            printWriter.append(message);
            printWriter.flush();
            printWriter.close();

        } catch (FileNotFoundException e)
        {
            System.out.println("Problem writing to log file.");
        }
    }

    private static String generateDateTimeStamp() {
        LocalDateTime timeStamp = LocalDateTime.now();
        DateTimeFormatter timeStampFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
        return timeStamp.format(timeStampFormatter);
    }


}