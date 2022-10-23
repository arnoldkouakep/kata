package fr.ingeniance.kata.pricer.treeforonedollar;

import java.util.List;

import fr.ingeniance.kata.pricer.data.Item;
import fr.ingeniance.kata.pricer.exception.ItemErrorException;
import fr.ingeniance.kata.pricer.exception.ProductNotFoundException;

public class ThreeForOneDollarPricer {

	private ThreeForOneDollarPricer() {
		throw new IllegalStateException("ThreeForOneDollarPricer class");
	}

	public static double threeForOneDollar(Item item, int qte) throws ProductNotFoundException, ItemErrorException {

		if (item.getProduct() == null)
			throw new ProductNotFoundException("The product of item cannot be null.");
		else if (item.getAmount() < 0)
			throw new ItemErrorException("The amount's item cannot be negative.");
		else if (item.getUnity() == null)
			throw new ItemErrorException("The unity of this item cannot be null.");
		else if (item.getUnity() < 0)
			throw new ItemErrorException("The unity of this item cannot be negative.");

		Double totalAmount = (qte * item.getAmount() / item.getUnity());

		return totalAmount.intValue() + (totalAmount > totalAmount.intValue() ? 1D : 0D);
	}

	public static double threeForOneDollar(List<Item> items, int qte)
			throws ProductNotFoundException, ItemErrorException {
		Double totalAmount = 0D;
		for (Item item : items) {
			if (item.getProduct() == null)
				throw new ProductNotFoundException("The product of item cannot be null.");
			else if (item.getAmount() < 0)
				throw new ItemErrorException("The amount's item cannot be negative.");
			else if (item.getUnity() == null)
				throw new ItemErrorException("The unity of this item cannot be null.");
			else if (item.getUnity() < 0)
				throw new ItemErrorException("The unity of this item cannot be negative.");

			totalAmount += (qte * item.getAmount() / item.getUnity());
		}

		return totalAmount.intValue() + (totalAmount > totalAmount.intValue() ? 1D : 0D);
	}
}
