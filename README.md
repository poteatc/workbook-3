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

   ## DEMO
   Home Page: 
   ![image](https://github.com/user-attachments/assets/53c08b06-ea6a-475a-bd80-e71c9f0c4b84)

   Products Display Screen:
   ![image](https://github.com/user-attachments/assets/e2e0b8a7-85dc-46cb-b6f3-c96c3f85fb82)
   ![image](https://github.com/user-attachments/assets/de5eb8b2-b655-49b3-ba66-5c82f0d04593)

   Invalid Input Example:
   ![image](https://github.com/user-attachments/assets/2056d19f-bf4b-4a17-8cd1-4c0c03a6e669)

   Interesting Code:
   ![image](https://github.com/user-attachments/assets/733e3126-b1bb-4af2-98df-22e1daf92d00)
   ![image](https://github.com/user-attachments/assets/c49dd6d0-3253-4bc1-8f42-bbf3e696716f)
   This code calculates the total amount due for products in the cart, then generates a receipt that is printed to the console




