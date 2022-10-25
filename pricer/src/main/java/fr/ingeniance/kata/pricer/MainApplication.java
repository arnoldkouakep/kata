package fr.ingeniance.kata.pricer;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.ingeniance.kata.pricer.buytwogetonefree.BuyTwoGetOneFree;
import fr.ingeniance.kata.pricer.data.Item;
import fr.ingeniance.kata.pricer.data.Pricer;
import fr.ingeniance.kata.pricer.data.Product;
import fr.ingeniance.kata.pricer.enumeration.WeigthUnit;
import fr.ingeniance.kata.pricer.exception.BadUnitConversionException;
import fr.ingeniance.kata.pricer.exception.ItemErrorException;
import fr.ingeniance.kata.pricer.exception.ProductNotFoundException;
import fr.ingeniance.kata.pricer.simple.SimplePricer;
import fr.ingeniance.kata.pricer.treeforonedollar.ThreeForOneDollarPricer;
import fr.ingeniance.kata.pricer.unitconversionpricer.UnitConversionPricer;

public class MainApplication {

	private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public static void main(String[] args) {

		Item itemError = new Item(null, null, 0.65D);

		printSimplePricer(itemError);

		Product product = new Product("beans", "can");
		Item item = new Item(product, null, 0.65D);

		printSimplePricer(item);

		product.setConditionnement(null);
		Item item2 = new Item(product, null, 0.65D);
		printSimplePricer(item2);

		Item item3 = new Item(product, 3, 1D);
		printThreeForOneDollarPricer(Arrays.asList(new Pricer(item3, 4)));

		printThreeForOneDollarPricer(Arrays.asList(new Pricer(item3, 5)));

		product.setUnit(WeigthUnit.POUND.toString());
		Item item4 = new Item(product, 1, 1.99D);
		printUnitConversionPricer(item4, WeigthUnit.OUNCE, 4);
		printUnitConversionPricer(item3, WeigthUnit.KILOGRAMM, 4);

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

	public static void printThreeForOneDollarPricer(final List<Pricer> pricers) {

		logger.log(Level.INFO, () -> {
			try {
				return new StringBuilder().append(ThreeForOneDollarPricer.threeForOneDollar(pricers)).toString();
			} catch (ProductNotFoundException | ItemErrorException e) {
				logger.log(Level.SEVERE, e.getMessage());
				e.printStackTrace();
			}
			return null;
		});
	}

	public static void printUnitConversionPricer(final Item item, final WeigthUnit unit, final int qte) {
		logger.log(Level.INFO, () -> {
			try {
				return new StringBuilder().append(UnitConversionPricer.unitConversionPriver(item, unit.toString(), qte))
						.toString();
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
				return new StringBuilder().append(BuyTwoGetOneFree.buyTwoGetOneFree(item, qte)).toString();
			} catch (ProductNotFoundException | ItemErrorException e) {
				logger.log(Level.SEVERE, e.getMessage());
				e.printStackTrace();
			}
			return null;

		});
	}
}
