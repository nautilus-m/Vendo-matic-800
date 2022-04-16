package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Log {


    public static void log(String message) {
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        File logFile = new File("Log.txt");

        try (PrintWriter logReader = new PrintWriter(new FileOutputStream(logFile, true))) {
            logReader.println(">" + dtf.format(localDate) + " " + message);

        } catch (FileNotFoundException e) {
            System.err.println("Log file not found");
        }

    }

}
