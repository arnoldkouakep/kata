package fr.ingeniance.supermarket.strategy;

public class PricePerPoundPricingStrategy implements PricingStrategy {
    private final double pricePerPound;

    public PricePerPoundPricingStrategy(double pricePerPound) {
        this.pricePerPound = pricePerPound;
    }

    @Override
    public double calculatePrice(double basePrice, int quantity) {
        // Convert ounces to pounds (1 pound = 16 ounces)
        double pounds = (double) quantity / 16.0;
        return pricePerPound * pounds;
    }

    @Override
    public String getStrategyPricing() {
        return "Price Per Pound Pricing Strategy";
    }
}
