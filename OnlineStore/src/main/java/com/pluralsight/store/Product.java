package com.pluralsight.store;

public class Product {
    // Private fields for storing product details
    private String sdk;            // SKU or unique identifier for the product
    private String productName;     // Name of the product
    private double price;           // Price of the product
    private String department;      // Department to which the product belongs

    // Constructor to initialize product details
    public Product(String sdk, String productName, double price, String department) {
        this.sdk = sdk;
        this.productName = productName;
        this.price = price;
        this.department = department;
    }

    // Getter and setter for the SDK
    public String getSdk() {
        return sdk;
    }

    public void setSdk(String sdk) {
        this.sdk = sdk;
    }

    // Getter and setter for the product name
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    // Getter and setter for the product price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Getter and setter for the department
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // Overrides the toString() method to provide a formatted string representation of the product
    @Override
    public String toString() {
        return String.format("""
                Product Name: %s
                SDK: %s
                Price: $%.2f
                Department: %s
                """, productName, sdk, price, department);
    }
}

