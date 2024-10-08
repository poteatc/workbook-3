package com.pluralsight.story;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StoryApp {
    public static void main(String[] args) {

        FileInputStream fis = null; //FileNotFoundException is a checked exception
        try {
            fis = new FileInputStream("./src/main/resources/goldilocks.txt");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Scanner scanner = new Scanner(fis);

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            System.out.println(input);
        }
    }
}
