# workbook-3
# OnlineStore

The `OnlineStore` is a Java-based console application that simulates an online shopping experience. The program allows users to view available products, add items to their cart, and complete the checkout process. It features a simple product search, cart management, and receipt generation.

## Features

- **Product Catalog**: View a list of products available in the store.
- **Product Search**: Search for products by name, price, or department.
- **Cart Management**: Add or remove products from the shopping cart.
- **Checkout**: Complete the purchase by entering payment information and receive a printed receipt.
- **Receipt Generation**: Generate and save a detailed sales receipt after checkout.

## Structure

The project consists of two main Java classes:

### 1. `Store`
The `Store` class is the core of the application, handling user interaction, cart management, and payment processing. Key features include:

- **Home Screen**: Provides options for viewing products, viewing the cart, and exiting the application.
- **Product Management**: Displays all available products and allows users to search by name, price, or department.
- **Cart Management**: Allows users to add products to the cart, view the cart's contents, remove items, and proceed to checkout.
- **Checkout**: Handles payment, displays the total sales amount, and generates a receipt.

### 2. `Product`
Each product in the store is represented by an instance of the `Product` class, which stores details such as the product name, price, department, and SDK (Stock Keeping Unit).

## How It Works

1. **Home Screen**: Upon launching the application, the home screen presents the user with three options:
   - View all products
   - View cart
   - Exit the store

2. **Product Viewing**: When selecting to view products, users can search by name, price, or department, or directly add products to the cart.

3. **Cart Viewing**: Users can view the contents of their cart, check out, or remove items.

4. **Checkout Process**: During checkout, the user provides payment information. A detailed receipt is printed to the console and saved to a file.
