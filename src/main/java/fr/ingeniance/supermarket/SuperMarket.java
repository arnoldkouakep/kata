package fr.ingeniance.supermarket;

import fr.ingeniance.Main;
import fr.ingeniance.supermarket.data.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SuperMarket {
    private static Map<String, Product> products;
    public SuperMarket() {
        products = new HashMap<>();
    }
    public void addProduct(String name, double basePrice) {
        Product product = new Product(name, basePrice);
        products.put(name, product);
    }
    public static void listProducts() {
        System.out.println("Available Products:");
        for (Map.Entry<String, Product> product : products.entrySet()) {
            System.out.println(product.toString());
        }
    }
    public void startShopping() {
        try (Scanner scanner = new Scanner(System.in)) {
            openSuperMarket();

            System.out.print("KATA-Supermarket: \nEnter your name: ");
            String customerName = scanner.nextLine();
            ShoppingCart cart = new ShoppingCart();
            boolean exit = false; // Use a flag to control the exit of the loop.

            while (!exit) {
                System.out.println("\nWhat would you like to do, " + customerName + "?");
                System.out.print("1. List Products\n" +
                        "2. Add a Product to Cart\n" +
                        "3. View Cart\n" +
                        "4. Exit\n\t\tMake a choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        listProducts();
                        break;
                    case 2:
                        listProducts();
                        System.out.print("Enter the name of the product you want to add to the cart: ");
                        scanner.nextLine(); // Consume the newline character left in the buffer
                        String productName = scanner.nextLine();
                        // Perform a case-insensitive search in the product map
                        Product selectedProduct = findProductByName(productName);

                        if (selectedProduct != null) {
                            System.out.print("Enter the quantity you want to add: ");
                            int quantity = scanner.nextInt();

                            cart.addItem(selectedProduct, quantity);
                            System.out.println(quantity + " " + selectedProduct.getName() + "(s) added to the cart.");
                        } else {
                            System.out.println("The product is not available.");
                        }
                        break;
                    case 3:
                        cart.displayCart();
                        break;
                    case 4:
                        System.out.println("Thank you for shopping, " + customerName + "!");
                        System.out.print("Press Enter to return to the Main Menu...");
                        scanner.nextLine(); // Consume the newline character left in the buffer
                        Main.main(null);
                        exit = true; // Exit the loop.
                        break;
                    default:
                        System.out.println("Invalid choice. Please choose a valid option.");
                }
            }
        }
    }
    private void openSuperMarket() {
        SuperMarket supermarket = new SuperMarket();
        supermarket.addProduct("Beans", 0.65);
        supermarket.addProduct("Apples", 1.99);
        supermarket.addProduct("Bananas", 1.99);
        supermarket.addProduct("Chocolates", 2.0);
        supermarket.addProduct("Cheese", 1.99);
    }
    // Helper method to find a product by name (case-insensitive)
    private Product findProductByName(String productName) {
        for (Map.Entry<String, Product> entry : products.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(productName)) {
                return entry.getValue();
            }
        }
        return null; // Product not found
    }
}
