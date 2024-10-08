package com.pluralsight.quotes;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FamousQuotes {
    public static void main(String[] args) {
        // Declare and initialize an array of 10 quotes
        String[] quotes = {
                "The greatest glory in living lies not in never falling, but in rising every time we fall. - Nelson Mandela",
                "The way to get started is to quit talking and begin doing. - Walt Disney",
                "Your time is limited, don't waste it living someone else's life. - Steve Jobs",
                "If life were predictable it would cease to be life, and be without flavor. - Eleanor Roosevelt",
                "If you look at what you have in life, you'll always have more. - Oprah Winfrey",
                "Life is what happens when you're busy making other plans. - John Lennon",
                "Spread love everywhere you go. Let no one ever come to you without leaving happier. - Mother Teresa",
                "Tell me and I forget. Teach me and I remember. Involve me and I learn. - Benjamin Franklin",
                "It is during our darkest moments that we must focus to see the light. - Aristotle",
                "Whoever is happy will make others happy too. - Anne Frank"
        };

        Scanner scanner = new Scanner(System.in);
        int input;
        boolean keepTrying = true;
        while (keepTrying) {
            System.out.println("Please enter a number between 1 and 10 to choose a quote: ");
            try {
                input = scanner.nextInt(); // Can throw InputMismatchException
                System.out.println(quotes[input - 1]); // Can throw ArrayIndexOutOfBoundsException
                scanner.nextLine(); // clear scanner buffer... closes loop if I don't have this statement
            } catch (Exception e) {
                System.out.println("Please enter a valid number...");
                scanner.nextLine(); // clear scanner buffer
            }
            System.out.println("Would you like to see another saying? Enter y for yes or anything else for no: ");
            String input1 = scanner.nextLine().trim();
            if (!input1.equalsIgnoreCase("y")) {
                keepTrying = false;
            }
        }

    }

}
