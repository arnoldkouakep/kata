package fr.ingeniance.kata.pricer.unitconversionpricer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.ingeniance.kata.pricer.data.Item;
import fr.ingeniance.kata.pricer.enumeration.WeigthUnit;
import fr.ingeniance.kata.pricer.exception.BadUnitConversionException;
import fr.ingeniance.kata.pricer.exception.ItemErrorException;
import fr.ingeniance.kata.pricer.exception.ProductNotFoundException;

public class UnitConversionPricer {

	protected static final Map<String, Double> conversionArray = new HashMap<>();

	static {
		conversionArray.put(WeigthUnit.POUND.toString(), 16D);
		conversionArray.put(WeigthUnit.KILOGRAMM.toString(), 35.274D);
		conversionArray.put(WeigthUnit.GRAMM.toString(), 0.035274D);
		conversionArray.put(WeigthUnit.OUNCE.toString(), 1D);
	}

	private UnitConversionPricer() {
		throw new IllegalStateException("UnitConversionPricer class");
	}

	public static double unitConversionPriver(Item item, String unit, int qte)
			throws ProductNotFoundException, ItemErrorException, BadUnitConversionException {

		if (item.getProduct() == null)
			throw new ProductNotFoundException("The product of item cannot be null.");
		else if (item.getAmount() < 0)
			throw new ItemErrorException("The amount's item cannot be negative.");
		else if (item.getUnity() == null)
			throw new ItemErrorException("The unity of this item cannot be null.");
		else if (conversionArray.get(unit) == null || conversionArray.get(item.getProduct().getUnit()) == null)
			throw new BadUnitConversionException("The unit conversion of this item or product cannot be null.");

		Double nqte;

		if (!item.getProduct().getUnit().equals(unit)) {
			nqte = item.getUnity() * conversionArray.get(unit) / conversionArray.get(item.getProduct().getUnit());
		} else {
			nqte = Double.valueOf(item.getUnity());
		}

		Double totalAmount = qte * item.getAmount() / nqte;

		return totalAmount.intValue() + (totalAmount > totalAmount.intValue() ? 1D : 0D);
	}

	public static double unitConversionPriverForItems(List<Item> items, String unit, int qte)
			throws ProductNotFoundException, ItemErrorException, BadUnitConversionException {
		Double totalAmount = 0D;

		for (Item item : items) {

			if (item.getProduct() == null)
				throw new ProductNotFoundException("The product of item cannot be null.");
			else if (item.getAmount() < 0)
				throw new ItemErrorException("The amount's item cannot be negative.");
			else if (item.getUnity() == null)
				throw new ItemErrorException("The unity of this item cannot be null.");
			else if (unit == null || item.getProduct().getUnit() == null || conversionArray.get(unit) == null
					|| conversionArray.get(item.getProduct().getUnit()) == null)
				throw new BadUnitConversionException("The unit conversion of this item or product cannot be null.");

			Double nqte;

			if (!item.getProduct().getUnit().equals(unit)) {
				nqte = item.getUnity() * conversionArray.get(unit) / conversionArray.get(item.getProduct().getUnit());
			} else {
				nqte = Double.valueOf(item.getUnity());
			}

			totalAmount += qte * item.getAmount() / nqte;
		}
		return totalAmount.intValue() + (totalAmount > totalAmount.intValue() ? 1D : 0D);
	}
}
