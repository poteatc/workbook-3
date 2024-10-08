package com.pluralsight.stories;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BedtimeStories {
    public static void main(String[] args) {

        boolean done = false;
        do {
            // Prompt the user for a file name
            System.out.println("Please enter the name of a file: ");
            Scanner inputScanner = new Scanner(System.in);
            String fileName = "./src/main/resources/";
            fileName += inputScanner.nextLine();

            FileInputStream fis = null;
            try {
                fis = new FileInputStream(fileName);
            } catch (FileNotFoundException e) {
                System.out.println("Invalid file name... try again");
                continue;
                //throw new RuntimeException(e);
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
    }
}
