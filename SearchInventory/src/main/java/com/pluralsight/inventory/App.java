package com.pluralsight.inventory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("./src/main/resources/inventory.csv");
            BufferedReader bfReader = new BufferedReader(fileReader);
            String input;
            while ((input = bfReader.readLine()) != null) {
                String[] split = input.split("[|]");
                products.add(new Product(Integer.parseInt(split[0]), split[1], Double.parseDouble(split[2])));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (Product p : products) {
            System.out.println(p);
        }
    }
}
