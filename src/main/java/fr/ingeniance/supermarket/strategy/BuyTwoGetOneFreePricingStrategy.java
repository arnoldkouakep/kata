package fr.ingeniance.supermarket.strategy;

public class BuyTwoGetOneFreePricingStrategy implements PricingStrategy {
    @Override
    public double calculatePrice(double basePrice, int quantity) {
        int setsOfThree = quantity / 3;
        int remainingItems = quantity % 3;
        return (setsOfThree * 2 * basePrice) + (remainingItems * basePrice);
    }

    @Override
    public String getStrategyPricing() {
        return "Buy Two Get One Free strategy";
    }
}