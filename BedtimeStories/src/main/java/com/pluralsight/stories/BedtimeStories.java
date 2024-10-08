package com.pluralsight.stories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BedtimeStories {
    public static void main(String[] args) {

        // A flag to control the loop. Initially, it is set to false, meaning the loop will run.
        boolean done = false;

        // Start a do-while loop to continuously prompt the user until they choose to exit.
        do {
            // Display the welcome message and instructions
            System.out.println("""
                    Welcome to the Bedtime Stories App
                    ----------------------------------
                    This application allows you to enter a file name
                    which will print its contents to the console
                    
                    Stories to choose from: 
                    -- goldilocks.txt
                    -- hansel_and_gretel.txt
                    -- mary_had_a_little_lamb.txt            
                    ----------------------------------
                    """);

            // Prompt the user for a file name
            System.out.println("Please enter the name of a file: ");

            // Create a scanner object to get user input from the console
            Scanner inputScanner = new Scanner(System.in);

            // Set the path to the file directory and append the user input for the file name
            String fileName = "./src/main/resources/";
            fileName += inputScanner.nextLine();  // Append the file name entered by the user

            FileInputStream fis = null;
            try {
                // Try to open the file with the given name
                fis = new FileInputStream(fileName);
            } catch (FileNotFoundException e) {
                // If the file is not found, inform the user and prompt them to try again or exit
                System.out.println("Invalid file name... Would you like to try again? Enter y for yes or anything else to exit");

                // Read the user's input
                String input = inputScanner.nextLine().trim();

                // If the user enters "y", restart the loop to allow another attempt, otherwise exit
                if (input.equalsIgnoreCase("y")) {
                    continue;  // Go back to the start of the loop
                } else {
                    break;  // Exit the loop
                }
            }

            // Create a new scanner to read the file contents
            Scanner fileScanner = new Scanner(fis);
            int lineNumber = 1;  // Initialize a counter for the line number

            // Read and print each line of the file with the line number
            while (fileScanner.hasNextLine()) {
                System.out.println(lineNumber + ": " + fileScanner.nextLine());  // Print the current line with line number
                lineNumber++;  // Increment the line number
            }

            // After printing the file, ask the user if they want to read another file
            System.out.println("\n\nWould you like to read another file? Enter y for yes or anything else to exit app: ");

            // If the user doesn't enter "y", set 'done' to true to exit the loop
            if (!inputScanner.nextLine().trim().equalsIgnoreCase("y")) {
                fileScanner.close();  // Close the file scanner
                done = true;  // Set the flag to true to terminate the loop
            }
        } while (!done);  // Continue the loop while 'done' is false

        // Inform the user that the application is exiting
        System.out.println("Exiting Application...");
    }
}
