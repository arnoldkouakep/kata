package fr.ingeniance.kata.pricer.buytwogetonefree;

import java.text.DecimalFormat;

import fr.ingeniance.kata.pricer.data.Item;
import fr.ingeniance.kata.pricer.exception.ItemErrorException;
import fr.ingeniance.kata.pricer.exception.ProductNotFoundException;

public class BuyTwoGetOneFree {

	private static final DecimalFormat df = new DecimalFormat("0.00");

	private BuyTwoGetOneFree() {
		throw new IllegalStateException("BuyTwoGetOneFree class");
	}

	public static String buyTwoGetOneFree(Item item, int qte) throws ProductNotFoundException, ItemErrorException {

		if (item.getProduct() == null)
			throw new ProductNotFoundException("The product of item cannot be null.");
		else if (item.getAmount() < 0)
			throw new ItemErrorException("The amount's item cannot be negative.");
		int twoThrids = qte / 2;
		return new StringBuilder().append("The third costs ")
				.append(df.format(item.getAmount() * qte / (qte + twoThrids))).append("$").toString();
	}
}
