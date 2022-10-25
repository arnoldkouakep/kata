package fr.ingeniance.kata.pricer.treeforonedollar;

import java.util.List;

import fr.ingeniance.kata.pricer.data.Pricer;
import fr.ingeniance.kata.pricer.exception.ItemErrorException;
import fr.ingeniance.kata.pricer.exception.ProductNotFoundException;

public class ThreeForOneDollarPricer {

	private ThreeForOneDollarPricer() {
		throw new IllegalStateException("ThreeForOneDollarPricer class");
	}

	public static double threeForOneDollar(Pricer pricer) throws ProductNotFoundException, ItemErrorException {

		Double totalAmount = 0D;

		if (pricer.getItem().getProduct() == null)
			throw new ProductNotFoundException("The product of item cannot be null.");
		else if (pricer.getItem().getAmount() < 0)
			throw new ItemErrorException("The amount's item cannot be negative.");
		else if (pricer.getItem().getUnity() == null)
			throw new ItemErrorException("The unity of this item cannot be null.");
		else if (pricer.getItem().getUnity() < 0)
			throw new ItemErrorException("The unity of this item cannot be negative.");

		totalAmount = totalAmount + (pricer.getQte() * pricer.getItem().getAmount() / pricer.getItem().getUnity());

		return totalAmount.intValue() + (totalAmount > totalAmount.intValue() ? 1D : 0D);
	}

	public static double threeForOneDollar(List<Pricer> pricers) throws ProductNotFoundException, ItemErrorException {
		Double totalAmount = 0D;
		for (Pricer pricer : pricers) {
			if (pricer.getItem().getProduct() == null)
				throw new ProductNotFoundException("The product of item cannot be null.");
			else if (pricer.getItem().getAmount() < 0)
				throw new ItemErrorException("The amount's item cannot be negative.");
			else if (pricer.getItem().getUnity() == null)
				throw new ItemErrorException("The unity of this item cannot be null.");
			else if (pricer.getItem().getUnity() < 0)
				throw new ItemErrorException("The unity of this item cannot be negative.");

			totalAmount = totalAmount + (pricer.getQte() * pricer.getItem().getAmount() / pricer.getItem().getUnity());
		}

		return totalAmount.intValue() + (totalAmount > totalAmount.intValue() ? 1D : 0D);
	}
}
