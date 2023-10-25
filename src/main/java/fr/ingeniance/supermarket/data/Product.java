package fr.ingeniance.supermarket.data;

public class Product {
    private final String name;
    private final double basePrice;
    public Product(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }
    public String getName() {
        return name;
    }
    public String toString() {
        return name + " - Base Price: " + basePrice;
    }
    public double calculatePrice(int quantity) {
        return basePrice * quantity;
    }
}
