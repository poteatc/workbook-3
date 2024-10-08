package com.pluralsight.stories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BedtimeStories {
    public static void main(String[] args) {

        boolean done = false;
        do {
            System.out.println("""
                    Welcome to the Bedtime Stories App
                    ----------------------------------
                    This application allows you to enter a file name
                    which will print its contents to the console
                    ----------------------------------
                    """);
            // Prompt the user for a file name
            System.out.println("Please enter the name of a file: ");
            Scanner inputScanner = new Scanner(System.in);
            String fileName = "./src/main/resources/";
            fileName += inputScanner.nextLine();

            FileInputStream fis = null;
            try {
                fis = new FileInputStream(fileName);
            } catch (FileNotFoundException e) {
                System.out.println("Invalid file name... Would you like to try again? Enter y for yes or anything else to exit");
                String input = inputScanner.nextLine().trim();
                if (input.equalsIgnoreCase("y")) {
                    continue;
                } else {
                    break;
                }
            }
            Scanner fileScanner = new Scanner(fis);
            int lineNumber = 1;
            while (fileScanner.hasNextLine()) {
                System.out.println(lineNumber + ": " + fileScanner.nextLine());
                lineNumber++;
            }
            System.out.println("\n\nWould you like to read another file? Enter y for yes or anything else to exit app: ");
            if (!inputScanner.nextLine().trim().equalsIgnoreCase("y")) {
                fileScanner.close();
                done = true;
            }
        } while (!done);
        System.out.println("Exiting Application...");
    }
}
