package fr.ingeniance.supermarket.strategy;

public interface PricingStrategy {
    double calculatePrice(double basePrice, int quantity);
    String getStrategyPricing();
}
