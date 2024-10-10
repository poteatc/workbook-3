package com.pluralsight.store;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    private static ArrayList<Product> inventory = new ArrayList<>();
    private static ArrayList<Product> cart = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        loadProductInventory();
        displayStoreHomeScreen();
    }

    private static void displayStoreHomeScreen() {
        boolean done = false;
        do {
            System.out.println("""
                    ***************************
                    *    Store Home Screen    *
                    ***************************
                    """);
            String prompt = """
                    Please enter an option:
                    A) View all products
                    B) Search by Product Name
                    C) Search by Price
                    D) Search by Department
                    E) Add Item to Cart
                    F) View Cart
                    G) Remove Item from Cart
                    X) Exit
                    """;
            System.out.println(prompt);
            String input = scanner.nextLine().toLowerCase().trim();
            switch (input) {
                case "a":
                    displayAllProducts();
                    break;
                case "b":
                    System.out.println("Please enter the product name: ");
                    input = scanner.nextLine().trim();
                    searchByProductName(input);
                    break;
                case "c":
                    System.out.println("Please enter the price of the product (ex. 0.00): ");
                    input = scanner.nextLine().trim();
                    searchByPrice(input);
                    break;
                case "d":
                    System.out.println("Please enter the name of the department: ");
                    input = scanner.nextLine().trim();
                    searchByDepartment(input);
                    break;
                case "x":
                    System.out.println("Exiting application...");
                    done = true;
                    break;
                default:
                    System.out.println("Please enter a valid option... ");
                    break;
            }

        } while (!done);
    }

    private static void searchByDepartment(String department) {
        boolean done = false;
        boolean validDepartmentName = false;
        do {
            for (Product p : inventory) {
                if (department.equalsIgnoreCase(p.getDepartment())) {
                    validDepartmentName = true;
                    System.out.println("""
                            --------------
                            """ + p + """ 
                            
                            --------------
                            """);
                }
            }
            if (!validDepartmentName) {
                System.out.println("Please enter a valid department name...");
            }
            done = true;
        } while (!done);
    }

    private static void searchByPrice(String price) {
        boolean found = false;
        boolean done = false;
        do {
            try {
                for (Product p : inventory) {
                    if (Double.parseDouble(price) == p.getPrice()) {
                        found = true;
                        System.out.println("""
                                \n
                                Search result:
                                --------------
                                """ + p + """
                                
                                --------------
                                \n
                                """);
                        done = true;
                    }
                }
                if (!found) {
                    System.out.println("There are no products with that price...\n");
                    done = true;
                }
            } catch (Exception e) {
                System.out.println("Please enter a valid price in the format: 0.00\n");
                done = true;
            }
        } while (!done);
    }

    private static void searchByProductName(String productName) {
        boolean found = false;
        for (Product p : inventory) {
            if (productName.equalsIgnoreCase(p.getProductName())) {
                found = true;
                System.out.println("""
                        \n
                        Search result:
                        --------------
                        """ + p + """
                        
                        --------------
                        \n
                        """);
            }
        }

        if (!found) {
            System.out.println("We couldn't find any products by that name...");
        }
    }

    private static void displayAllProducts() {
        for (Product p : inventory) {
            System.out.printf("""
                    -----
                    %s
                    -----\n""", p);
        }
    }

    private static void loadProductInventory() {
        try {
            FileReader fr = new FileReader("./src/main/resources/products.csv");
            BufferedReader bfReader = new BufferedReader(fr);
            String input = bfReader.readLine(); // initialize file line input and skip first line of csv
            while ((input = bfReader.readLine()) != null) {
                String[] info = input.split("[|]");
                inventory.add(new Product(info[0], info[1], Double.parseDouble(info[2]), info[3]));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
