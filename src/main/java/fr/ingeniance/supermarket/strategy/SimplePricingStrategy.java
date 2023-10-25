package fr.ingeniance.supermarket.strategy;

public class SimplePricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double basePrice, int quantity) {
        return basePrice * quantity;
    }
    @Override
    public String getStrategyPricing() {
        return "Simple pricing strategy";
    }
}
