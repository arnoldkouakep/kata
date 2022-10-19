package fr.ingeniance.kata.pricer.simple;

import java.util.List;

import fr.ingeniance.kata.pricer.data.Item;
import fr.ingeniance.kata.pricer.exception.ItemErrorException;
import fr.ingeniance.kata.pricer.exception.ProductNotFoundException;

public class SimplePricer {

	private SimplePricer() {
		throw new IllegalStateException("SimplePricer class");
	}

	public static String simplePriceOfProduct(Item item) throws ProductNotFoundException, ItemErrorException {

		if (item.getProduct() == null)
			throw new ProductNotFoundException("The product of item cannot be null.");
		else if (item.getAmount() < 0)
			throw new ItemErrorException("The amount's item cannot be negative.");

		return new StringBuilder().append("This ")
				.append(item.getProduct().getConditionnement() == null ? "" : item.getProduct().getConditionnement())
				.append(item.getProduct().getConditionnement() == null ? "" : " of ")
				.append(item.getProduct().getName()).append(" costs ").append(item.getAmount()).append("$").toString();
	}

	public static String simplePriceOfProduct(List<Item> items) throws ProductNotFoundException, ItemErrorException {
		Double totalAmount = 0D;
		for (Item item : items) {
			if (item.getProduct() == null)
				throw new ProductNotFoundException("The product of item cannot be null.");
			else if (item.getAmount() < 0)
				throw new ItemErrorException("The amount's item cannot be negative.");

			totalAmount += item.getAmount();
		}

		return new StringBuilder().append("Total amount : ").append(totalAmount).append("$").toString();
	}
}
