package fr.ingeniance.supermarket.data;

import fr.ingeniance.supermarket.strategy.PricingStrategy;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

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
        double rawPrice = pricingStrategy.calculatePrice(basePrice, quantity);

        // Create a DecimalFormat for the #.## format (period as decimal separator)
        DecimalFormat decimalFormatWithPeriod = new DecimalFormat("#.##");

        // Use a custom DecimalFormatSymbols to switch between period and comma
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.'); // Use period as decimal separator
        decimalFormatWithPeriod.setDecimalFormatSymbols(symbols);

        return Double.parseDouble(decimalFormatWithPeriod.format(rawPrice));
    }
}
