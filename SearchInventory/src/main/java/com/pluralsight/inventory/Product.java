package com.pluralsight.inventory;

public class Product {
    private int id;
    private String item;
    private double price;

    public Product(int id, String item, double price) {
        this.id = id;
        this.item = item;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("Product ID: #%d. %s item costs $%.2f", id, item, price);
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
