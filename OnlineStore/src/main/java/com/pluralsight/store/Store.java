package com.pluralsight.store;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

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
            System.out.print(ConsoleColors.BLUE_BOLD + """
                    ***************************
                    *    Store Home Screen    *
                    ***************************
                    """ + ConsoleColors.RESET);
            String prompt = ConsoleColors.CYAN_UNDERLINED + """
                    Please enter an option:\n""" + ConsoleColors.WHITE_BRIGHT +
                    """ 
                    A) View all products
                    B) View Cart
                    X) Exit
                    """ + ConsoleColors.RESET;
            System.out.println(prompt);
            String input = scanner.nextLine().toLowerCase().trim();
            switch (input) {
                case "a":
                    displayAllProducts();
                    break;
                case "b":
                    viewCart();
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

    private static void displayAllProducts() {
        System.out.println(ConsoleColors.GREEN_BOLD + """
                    
                    ****************************
                    *    Available Products    *
                    ****************************""" + ConsoleColors.RESET);
        for (Product p : inventory) {
            System.out.printf("""
                    ----------------------
                    %s
                    ----------------------\n""", p);
        }

        boolean done = false;
        do {
            String prompt = ConsoleColors.CYAN_UNDERLINED + """
                    
                    Please enter an option:\n""" + ConsoleColors.RESET + ConsoleColors.WHITE_BOLD_BRIGHT + """
                    A) Search by Product Name
                    B) Search by Price
                    C) Search by Department
                    D) Add a Product to Cart
                    X) Return to Store Home Screen
                    """ + ConsoleColors.RESET;
            System.out.println(prompt);
            String input = scanner.nextLine().toLowerCase().trim();
            switch (input) {
                case "a":
                    System.out.println("Please enter the product name: ");
                    input = scanner.nextLine().trim();
                    searchByProductName(input);
                    break;
                case "b":
                    System.out.println("Please enter the price of the product (ex. 0.00): ");
                    input = scanner.nextLine().trim();
                    searchByPrice(input);
                    break;
                case "c":
                    System.out.println("Please enter the name of the department: ");
                    input = scanner.nextLine().trim();
                    searchByDepartment(input);
                    break;
                case "d":
                    //System.out.println("Please enter the name of the product to add to your cart");
                    //input = scanner.nextLine().trim();
                    addProductToCart();
                    break;
                case "x":
                    System.out.println("");
                    done = true;
                    break;
                default:
                    System.out.println("Please enter a valid option... ");
                    break;
            }
        } while (!done);
    }




    /*
    This displays a list of line items that are in the customer's cart.
    It should also display the total sales amount of the cart.
    The customer should be able to:
    - Check Out
    - Remove Product from the cart
    - Go Back to the home screen
    If the customer chooses to remove a product need to prompt them for the product to remove

     */
    private static void viewCart() {
        boolean done = false;
        do {
            System.out.println("""
                ***************************
                *        Your Cart        *
                ***************************
                """);
            if (cart.isEmpty()) {
                System.out.println("Your cart is empty...\n");
            }
            for (Product p : cart) {
                System.out.println("""
                            (~~~~~~~~~~~~~~)
                            """ + p + """ 
                            
                            (~~~~~~~~~~~~~~)
                            """);
            }
            System.out.println("""
                    Please enter an option:
                    A) Check Out
                    B) Remove Product from Cart
                    X) Return to Store Home Screen
                    """);
            String input = scanner.nextLine().toLowerCase().trim();
            switch (input) {
                case "a":
                    checkOut();
                    break;
                case "b":
                    removeProductFromCart();
                    break;
                case "x":
                    done = true;
                    break;
                default:
                    System.out.println("Please enter a valid option... ");
                    break;
            }
        } while (!done);

    }

    private static void checkOut() {
        if (!cart.isEmpty()) {
            System.out.println("""
                \n
                ***************************
                *        Check Out        *
                ***************************
                    """);
            double totalPrice = 0.0;
            for (Product p : cart) {
                System.out.println("""
                            (~~~~~~~~~~~~~~)
                            """ + p + """ 
                            
                            (~~~~~~~~~~~~~~)
                            """);
                totalPrice += p.getPrice();
            }
            System.out.println("The total sales amount of your cart is $" + totalPrice);
            System.out.println("\nAre you ready to check out? Enter 'Y' for yes or any other key for no");
            String input = scanner.nextLine().toLowerCase().trim();
            if (input.equalsIgnoreCase("y")) {
                boolean validInput = false;
                do {
                    System.out.println("Please enter your payment in cash: ");
                    double cash = 0.0;
                    input = scanner.nextLine().trim();
                    try {
                        cash = Double.parseDouble(input);
                        if (cash >= totalPrice) {
                            printSalesReceipt(cash, totalPrice);
                            validInput = true;
                        } else {
                            System.out.println("Your payment amount is not sufficient...");
                        }
                    } catch (Exception e) {
                        System.out.println("Please enter valid input (0.00)...");
                    }
                    System.out.println("Would you like to return to Check Out Menu? Enter 'Y' for yes or any other key for no");
                    input = scanner.nextLine().toLowerCase().trim();
                    if (input.equalsIgnoreCase("y")) {
                        break;
                    }
                } while (!validInput);

            }
        }
    }

    private static void printSalesReceipt(double cash, double totalPrice) {
        LocalDateTime ldt = LocalDateTime.now();
       //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddhhmm");
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("MMMM dd, yyyy hh:mm:ss a");
        System.out.println("\n" + ConsoleColors.WHITE_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD + "Date: " + dtf1.format(ldt));
        System.out.println(ConsoleColors.WHITE_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD + "Thank you for ordering from our online store!!!");
        System.out.println(ConsoleColors.WHITE_BACKGROUND_BRIGHT + ConsoleColors.BLACK_UNDERLINED + "Here is your receipt:");
        System.out.print(ConsoleColors.RESET);
        for (Product p : cart) {
            System.out.format(ConsoleColors.WHITE_BACKGROUND_BRIGHT + ConsoleColors.BLACK_BOLD + "\n%-40s $%.2f\n", p.getProductName(), p.getPrice());
        }
        System.out.format("\n%-40s $%.2f", "Sales Total:", totalPrice);
        System.out.format("\n%-40s $%.2f", "Amount Paid:", cash);
        System.out.format("\n%-40s $%.2f\n", "Change:", (cash - totalPrice));
        System.out.println(ConsoleColors.RESET);
        try {
            DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyyMMddhhmm");
            String fileName = "./src/main/resources/Receipts/" + dtf2.format(ldt) + ".txt";
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(String.format("Date: %s\n", dtf1.format(ldt)));
            bufferedWriter.write("Thank you for ordering from our online store!!!\n");
            bufferedWriter.write("Here is your receipt:\n");
            for (Product p : cart) {
                bufferedWriter.write(String.format("\n%-40s $%.2f\n", p.getProductName(), p.getPrice()));
            }
            bufferedWriter.write(String.format("\n%-40s $%.2f", "Sales Total:", totalPrice));
            bufferedWriter.write(String.format("\n%-40s $%.2f", "Amount Paid:", cash));
            bufferedWriter.write(String.format("\n%-40s $%.2f\n", "Change:", (cash - totalPrice)));
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        cart.removeAll(cart);
    }

    private static void addProductToCart() {
        boolean found = false;
        boolean done = false;
        do {
            System.out.println("Please enter the product name or SDK");
            String input = scanner.nextLine().toLowerCase().trim();
            // Can throw ConcurrentModificationException
            // Solution: use a CopyOnWriteArrayList
            // Create a copy of the collection
            List<Product> list = new CopyOnWriteArrayList<>(inventory);
            List<Product> copy = new ArrayList<>(list);

            //Iterate over the copy, while modifying the original.
            for (Product p : copy) {
                if (input.equalsIgnoreCase(p.getProductName()) || input.equalsIgnoreCase(p.getSdk())) {
                    found = true;
                    System.out.println("Added " + p.getProductName() + " to your cart!\n");
                    cart.add(p);
                    inventory.remove(p);
                    done = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Invalid product name...");
                System.out.println("Would you like to enter the product name or sdk again? Enter 'Y' for yes or any other key for no.");
                input = scanner.nextLine().trim();
                if (!input.equalsIgnoreCase("y")) {
                    done = true;
                }
            }
        } while (!done);
    }

    private static void removeProductFromCart() {
        if (cart.isEmpty()) {
            System.out.println("There is nothing to remove from your cart...\n");
            return;
        }
        boolean found = false;
        boolean done = false;
        do {
            System.out.println("Please enter the product name or SDK");
            String input = scanner.nextLine().toLowerCase().trim();
            // Can throw ConcurrentModificationException
            // Solution: use a CopyOnWriteArrayList
            // Create a copy of the collection
            List<Product> list = new CopyOnWriteArrayList<>(cart);
            List<Product> copy = new ArrayList<>(list);

            //Iterate over the copy, while modifying the original.
            for (Product p : copy) {
                if (input.equalsIgnoreCase(p.getProductName()) || input.equalsIgnoreCase(p.getSdk())) {
                    found = true;
                    System.out.println("Removed " + p.getProductName() + " from your cart!\n");
                    cart.remove(p);
                    inventory.add(p);
                    done = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Invalid product name...");
                System.out.println("Would you like to enter a product name again? Enter 'Y' for yes or any other key for no.");
                input = scanner.nextLine().trim();
                if (!input.equalsIgnoreCase("y")) {
                    done = true;
                }
            }
        } while (!done);
    }

    private static void searchByDepartment(String department) {
        boolean done = false;
        boolean validDepartmentName = false;
        do {
            System.out.println("\nSearch results: ");
            for (Product p : inventory) {
                if (department.equalsIgnoreCase(p.getDepartment())) {
                    validDepartmentName = true;
                    System.out.println("""
                            <^^^^^^^^^^^^^^>
                            """ + p + """ 
                            
                            <^^^^^^^^^^^^^^>
                            """);
                }
            }
            if (!validDepartmentName) {
                System.out.println("N/A");
                System.out.println("Please enter a valid department name...\n");
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
                        |--------------|
                        """ + p + """
                        
                        |--------------|
                        \n
                        """);
            }
        }

        if (!found) {
            System.out.println("We couldn't find any products by that name...");
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
