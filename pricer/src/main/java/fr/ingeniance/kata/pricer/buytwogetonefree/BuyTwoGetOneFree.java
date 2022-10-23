package fr.ingeniance.kata.pricer.buytwogetonefree;

import fr.ingeniance.kata.pricer.data.Item;
import fr.ingeniance.kata.pricer.exception.ItemErrorException;
import fr.ingeniance.kata.pricer.exception.ProductNotFoundException;

public class BuyTwoGetOneFree {

	private BuyTwoGetOneFree() {
		throw new IllegalStateException("BuyTwoGetOneFree class");
	}

	public static double buyTwoGetOneFree(Item item, int qte) throws ProductNotFoundException, ItemErrorException {

		if (item.getProduct() == null)
			throw new ProductNotFoundException("The product of item cannot be null.");
		else if (item.getAmount() < 0)
			throw new ItemErrorException("The amount's item cannot be negative.");
		int twoThrids = qte / 2;
		return item.getAmount() * qte / (qte + twoThrids);
	}
}
