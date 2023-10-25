package fr.ingeniance.supermarket;

import fr.ingeniance.supermarket.data.Product;
import junit.framework.TestCase;

public class SupermarketTest extends TestCase {
    public void testCalculateTotalCost() {
        ShoppingCart cart = new ShoppingCart();
        Product product1 = new Product("Beans", 0.65);
        Product product2 = new Product("Chocolates", 2.0);
        cart.addItem(product1, 3);
        cart.addItem(product2, 4);
        double totalCost = cart.calculateTotalCost();
        assertEquals(9.95, totalCost, 0.001);
    }

    // Add more test cases as needed.

    // Note: It's a good practice to isolate your tests for individual classes or methods.
}
