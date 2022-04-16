package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Log {

    public static void log(String message) {
    File logFile = new File("Log.txt");

        try(PrintWriter logReader = new PrintWriter(new FileOutputStream(logFile, true))) {
            logReader.println(message);

        } catch (FileNotFoundException e) {
            System.err.println("Log file not found");
        }

    }

}
