package fr.ingeniance.supermarket.strategy;

public class QuantityPricingStrategy implements PricingStrategy {
    private final int specialQuantity;
    private final double specialPrice;

    public QuantityPricingStrategy(int specialQuantity, double specialPrice) {
        this.specialQuantity = specialQuantity;
        this.specialPrice = specialPrice;
    }

    @Override
    public double calculatePrice(double basePrice, int quantity) {
        int regularQuantity = quantity % specialQuantity;
        int specialSets = quantity / specialQuantity;
        return (specialSets * specialPrice) + (regularQuantity * basePrice);
    }
    @Override
    public String getStrategyPricing() {
        return "Quantity pricing strategy";
    }
}
