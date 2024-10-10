package com.pluralsight.logging;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SearchEngineLogger {
    // Scanner for reading user input from the console
    private static Scanner scanner = null;

    public static void main(String[] args) {

        FileWriter fileWriter = null;
        try {
            // Create a FileWriter to write to a logs.txt file
            fileWriter = new FileWriter("./src/main/resources/logs.txt");
            // Wrap the FileWriter in a BufferedWriter for more efficient writing
            BufferedWriter bfWriter = new BufferedWriter(fileWriter);
            // Call method to get user input and log it to the file
            getUserInput(bfWriter);
        } catch (IOException e) {
            // In case of an I/O error, throw a RuntimeException
            throw new RuntimeException(e);
        }

    }

    // Method to handle user input and log search activities
    private static void getUserInput(BufferedWriter bfWriter) {
        // Initialize the scanner for reading from System.in (the console)
        scanner = new Scanner(System.in);
        System.out.println("Enter a search term (X to exit): ");

        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();
        // Format the date and time to "yyyy-MM-dd KK:mm:ss" pattern
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd KK:mm:ss ");

        try {
            // Log the application launch time to both the console and the file
            System.out.println(dtf.format(now) + "launch");
            bfWriter.write(dtf.format(now) + "launch\n");

            boolean done = false; // Flag to indicate when the user wants to exit
            do {
                // Update the current time for each search attempt
                now = LocalDateTime.now();

                // Prompt user for a search term
                System.out.print(dtf.format(now) + "search : ");
                String input = scanner.nextLine(); // Read user input

                // If the user types "X" (case-insensitive), end the loop and log exit time
                if (input.equalsIgnoreCase("x")) {
                    now = LocalDateTime.now(); // Update exit time
                    // Log the exit time to the file and console
                    bfWriter.write(dtf.format(now) + "exit");
                    System.out.println(dtf.format(now) + "exit");
                    done = true; // Set done to true to break out of the loop
                } else {
                    now = LocalDateTime.now(); // Update time after search.. maybe not necessary
                    // Log the search query and time to the file
                    bfWriter.write(dtf.format(now) + "search : ");
                    bfWriter.write(input + "\n");
                }

                // Debugging option (commented out): Print the input to the console for testing
                // System.out.print(input + "\n");
            }
            while (!done); // Continue until the user enters "X"

            // Close the BufferedWriter after logging is complete
            bfWriter.close();

        } catch (IOException e) {
            // Throw an exception if there's an error with file writing
            throw new RuntimeException(e);
        }
    }
}

