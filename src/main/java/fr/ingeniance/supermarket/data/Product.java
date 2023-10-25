package fr.ingeniance.supermarket.data;

import fr.ingeniance.supermarket.strategy.PricingStrategy;

public class Product {
    private final String name;
    private final double basePrice;
    private final PricingStrategy pricingStrategy;
    public Product(String name, double basePrice, PricingStrategy pricingStrategy) {
        this.name = name;
        this.basePrice = basePrice;
        this.pricingStrategy = pricingStrategy;
    }
    public String getName() {
        return name;
    }
    public String toString() {
        return name + " - Base Price: " + basePrice + " - Available Promotion : " + pricingStrategy.getStrategyPricing();
    }
    public double calculatePrice(int quantity) {
        return pricingStrategy.calculatePrice(basePrice, quantity);
    }
}
