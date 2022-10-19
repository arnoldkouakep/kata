package fr.ingeniance.kata.pricer;

import java.util.logging.Level;
import java.util.logging.Logger;

import fr.ingeniance.kata.pricer.data.Item;
import fr.ingeniance.kata.pricer.data.Product;
import fr.ingeniance.kata.pricer.exception.ItemErrorException;
import fr.ingeniance.kata.pricer.exception.ProductNotFoundException;
import fr.ingeniance.kata.pricer.simple.SimplePricer;

public class MainApplication {

	private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public static void main(String[] args) {

		Item itemError = new Item(1L, null, null, 0.65D);

		printSimplePricer(itemError);

		Product product = new Product(1L, "P001", "can", "beans");
		Item item = new Item(1L, product, null, 0.65D);

		printSimplePricer(item);

		Product product2 = new Product(1L, "P002", null, "beans");
		Item item2 = new Item(1L, product2, null, 0.65D);
		printSimplePricer(item2);

	}

	public static void printSimplePricer(final Item item) {
		logger.log(Level.INFO, () -> {
			try {
				return SimplePricer.simplePriceOfProduct(item);
			} catch (ProductNotFoundException | ItemErrorException e) {
				logger.log(Level.SEVERE, e.getMessage());
				e.printStackTrace();
			}
			return null;
		});
	}
}
