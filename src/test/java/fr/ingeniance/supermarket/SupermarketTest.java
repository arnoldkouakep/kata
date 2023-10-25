package fr.ingeniance.supermarket;

import fr.ingeniance.supermarket.data.Product;
import fr.ingeniance.supermarket.strategy.*;
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
    public void testBuyTwoGetOneFreePricingStrategy() {
        PricingStrategy pricingStrategy = new BuyTwoGetOneFreePricingStrategy();
        double calculatedPrice = pricingStrategy.calculatePrice(2.0, 4);
        assertEquals(6.0, calculatedPrice, 0.001);
    }
    public void testPricePerPoundPricingStrategy() {
        PricingStrategy pricingStrategy = new PricePerPoundPricingStrategy(1.99);
        double calculatedPrice = pricingStrategy.calculatePrice(1.99, 16); // 1 pound
        assertEquals(1.99, calculatedPrice, 0.001);
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
    public void test3CalculateTotalCost() {
        ShoppingCart cart = new ShoppingCart();
        Product product1 = new Product("Beans", 0.65, new SimplePricingStrategy());
        Product product2 = new Product("Apples", 1.99, new QuantityPricingStrategy(3, 1.0));
        Product product3 = new Product("Chocolates", 2.0, new BuyTwoGetOneFreePricingStrategy());
        cart.addItem(product1, 3);
        cart.addItem(product2, 4);
        cart.addItem(product3, 6);
        double totalCost = cart.calculateTotalCost();
        assertEquals(12.94, totalCost, 0.001);
    }
    public void test4CalculateTotalCost() {
        ShoppingCart cart = new ShoppingCart();
        Product product1 = new Product("Beans", 0.65, new SimplePricingStrategy());
        Product product2 = new Product("Apples", 1.99, new QuantityPricingStrategy(3, 1.0));
        Product product3 = new Product("Chocolates", 2.0, new BuyTwoGetOneFreePricingStrategy());
        Product product4 = new Product("Cheese", 1.99, new PricePerPoundPricingStrategy(1.99));
        cart.addItem(product1, 3);
        cart.addItem(product2, 4);
        cart.addItem(product3, 6);
        cart.addItem(product4, 16);
        double totalCost = cart.calculateTotalCost();
        assertEquals(14.93, totalCost, 0.001);
    }
}
