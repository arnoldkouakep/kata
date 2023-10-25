package fr.ingeniance.supermarket;

import fr.ingeniance.supermarket.data.Product;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private final Map<Product, Integer> cart;

    public ShoppingCart() {
        cart = new HashMap<>();
    }
    public void addItem(Product product, Integer quantity) {
        cart.merge(product, quantity, Integer::sum);
    }
    public double calculateTotalCost() {
        double totalCost = 0.0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            totalCost += entry.getKey().calculatePrice(entry.getValue());
        }
        return totalCost;
    }
    public void displayCart() {
        System.out.println("Shopping Cart:");
        for (Map.Entry<Product, Integer> item : cart.entrySet()) {
            System.out.println(item.getKey().getName() + " - Quantity : " + item.getValue());
        }
        System.out.println("Total: " + calculateTotalCost() + "€");
    }
}
