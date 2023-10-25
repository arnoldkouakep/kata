package fr.ingeniance.supermarket;

import fr.ingeniance.supermarket.data.Product;
import fr.ingeniance.supermarket.strategy.PricingStrategy;
import fr.ingeniance.supermarket.strategy.QuantityPricingStrategy;
import fr.ingeniance.supermarket.strategy.SimplePricingStrategy;
import junit.framework.TestCase;

public class SupermarketTest extends TestCase {
    public void testSimplePricingStrategy() {
        PricingStrategy pricingStrategy = new SimplePricingStrategy();
        double calculatedPrice = pricingStrategy.calculatePrice(0.65, 3);
        assertEquals(1.95, calculatedPrice, 0.001);
    }
    public void testQuantityPricingStrategy() {
        PricingStrategy pricingStrategy = new QuantityPricingStrategy(3, 1.0);
        double calculatedPrice = pricingStrategy.calculatePrice(1.0, 5);
        assertEquals(3.0, calculatedPrice, 0.001);
    }
    public void test1CalculateTotalCost() {
        ShoppingCart cart = new ShoppingCart();
        Product product1 = new Product("Beans", 0.65, new SimplePricingStrategy());
        Product product2 = new Product("Chocolates", 2.0, new SimplePricingStrategy());
        cart.addItem(product1, 3);
        cart.addItem(product2, 4);
        double totalCost = cart.calculateTotalCost();
        assertEquals(9.95, totalCost, 0.001);
    }
    public void test2CalculateTotalCost() {
        ShoppingCart cart = new ShoppingCart();
        Product product1 = new Product("Beans", 0.65, new SimplePricingStrategy());
        Product product2 = new Product("Apples", 1.99, new QuantityPricingStrategy(3, 1.0));
        cart.addItem(product1, 3);
        cart.addItem(product2, 4);
        double totalCost = cart.calculateTotalCost();
        assertEquals(4.94, totalCost, 0.001);
    }
}
