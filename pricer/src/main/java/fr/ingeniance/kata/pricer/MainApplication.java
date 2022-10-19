package fr.ingeniance.kata.pricer;

import java.util.logging.Level;
import java.util.logging.Logger;

import fr.ingeniance.kata.pricer.buytwogetonefree.BuyTwoGetOneFree;
import fr.ingeniance.kata.pricer.data.Item;
import fr.ingeniance.kata.pricer.data.Product;
import fr.ingeniance.kata.pricer.enumeration.EnumStatus;
import fr.ingeniance.kata.pricer.exception.BadUnitConversionException;
import fr.ingeniance.kata.pricer.exception.ItemErrorException;
import fr.ingeniance.kata.pricer.exception.ProductNotFoundException;
import fr.ingeniance.kata.pricer.simple.SimplePricer;
import fr.ingeniance.kata.pricer.treeforonedollar.ThreeForOneDollarPricer;
import fr.ingeniance.kata.pricer.unitconversionpricer.UnitConversionPricer;

public class MainApplication {

	private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public static void main(String[] args) {

		Item itemError = new Item(1L, null, null, 0.65D);

		printSimplePricer(itemError);

		Product product = new Product(1L, "P001", "can", "beans");
		Item item = new Item(1L, product, null, 0.65D);

		printSimplePricer(item);

		product.setConditionnement(null);
		Item item2 = new Item(1L, product, null, 0.65D);
		printSimplePricer(item2);

		Item item3 = new Item(1L, product, 3, 1D);
		printThreeForOneDollarPricer(item3, 4);

		printThreeForOneDollarPricer(item3, 5);

		product.setUnit(EnumStatus.POUND.toString());
		Item item4 = new Item(1L, product, 1, 1.99D);
		printUnitConversionPricer(item4, EnumStatus.OUNCE, 4);
		printUnitConversionPricer(item3, EnumStatus.KILOGRAMM, 4);

		printBuyTwoGetOneFree(item3, 7);

		printBuyTwoGetOneFree(item2, 4);

		printBuyTwoGetOneFree(item4, 10);

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

	public static void printThreeForOneDollarPricer(final Item item, final int qte) {
		logger.log(Level.INFO, () -> {
			try {
				return ThreeForOneDollarPricer.threeForOneDollar(item, qte);
			} catch (ProductNotFoundException | ItemErrorException e) {
				logger.log(Level.SEVERE, e.getMessage());
				e.printStackTrace();
			}
			return null;
		});
	}

	public static void printUnitConversionPricer(final Item item, final EnumStatus unit, final int qte) {
		logger.log(Level.INFO, () -> {
			try {
				return UnitConversionPricer.unitConversionPriver(item, unit.toString(), qte);
			} catch (ProductNotFoundException | ItemErrorException | BadUnitConversionException e) {
				logger.log(Level.SEVERE, e.getMessage());
				e.printStackTrace();
			}
			return null;

		});
	}

	public static void printBuyTwoGetOneFree(final Item item, final int qte) {
		logger.log(Level.INFO, () -> {
			try {
				return BuyTwoGetOneFree.buyTwoGetOneFree(item, qte);
			} catch (ProductNotFoundException | ItemErrorException e) {
				logger.log(Level.SEVERE, e.getMessage());
				e.printStackTrace();
			}
			return null;

		});
	}
}
