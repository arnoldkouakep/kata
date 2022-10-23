package fr.ingeniance.kata.buytwogetonefree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import fr.ingeniance.kata.pricer.buytwogetonefree.BuyTwoGetOneFree;
import fr.ingeniance.kata.pricer.data.Item;
import fr.ingeniance.kata.pricer.data.Product;
import fr.ingeniance.kata.pricer.enumeration.WeigthUnit;
import fr.ingeniance.kata.pricer.exception.BadUnitConversionException;
import fr.ingeniance.kata.pricer.unitconversionpricer.UnitConversionPricer;

class TestBuyTwoGetOneFree {

	@Test
	void whenExceptionThrown_thenUnitIsNull() throws Exception {

		Product product = new Product("beans", "can");
		Item item = new Item(product, 1, 1D);

		BadUnitConversionException ex = assertThrows(BadUnitConversionException.class, () -> {
			UnitConversionPricer.unitConversionPriver(item, null, 1);
		});

		assertEquals("The unit conversion of this item or product cannot be null.", ex.getMessage());

	}

	@Test
	void whenExceptionThrown_thenUnitNotInRanger() throws Exception {

		Product product = new Product("bean", "can", WeigthUnit.POUND.toString());
		Item item = new Item(product, 1, 1.99D);

		BadUnitConversionException ex = assertThrows(BadUnitConversionException.class, () -> {
			UnitConversionPricer.unitConversionPriver(item, "OUNCE2", 4);
		});

		assertEquals("The unit conversion of this item or product cannot be null.", ex.getMessage());

	}

	@Test
	void printBuyTwoGetOneFreeWith3() throws Exception {

		Product product = new Product("beans", "can");
		Item item = new Item(product, 1, 1D);

		assertEquals(0.75D, BuyTwoGetOneFree.buyTwoGetOneFree(item, 3));
	}

	@Test
	void printBuyTwoGetOneFreeWith7() throws Exception {

		Product product = new Product("beans", "can");
		Item item = new Item(product, 1, 1D);

		assertEquals(0.70D, BuyTwoGetOneFree.buyTwoGetOneFree(item, 7));
	}

}
