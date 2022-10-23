package fr.ingeniance.kata.unitconversionpricer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import fr.ingeniance.kata.pricer.data.Item;
import fr.ingeniance.kata.pricer.data.Product;
import fr.ingeniance.kata.pricer.enumeration.WeigthUnit;
import fr.ingeniance.kata.pricer.exception.ItemErrorException;
import fr.ingeniance.kata.pricer.exception.ProductNotFoundException;
import fr.ingeniance.kata.pricer.unitconversionpricer.UnitConversionPricer;

class TestUnitConversionPricer {

	@Test
	void whenExceptionThrown_thenUnitIsNull() throws Exception {

		Product product = new Product("beans", "can", WeigthUnit.POUND.toString());
		Item item = new Item(product, 1, 1.99D);

		ProductNotFoundException ex = assertThrows(ProductNotFoundException.class, () -> {
			UnitConversionPricer.unitConversionPriver(item, null, 1);
		});

		assertEquals("The unit conversion of this item or product cannot be null.", ex.getMessage());

	}

	@Test
	void whenExceptionThrown_thenUnitNotInRanger() throws Exception {

		Product product = new Product("bean", "can", WeigthUnit.POUND.toString());
		Item item = new Item(product, 1, 1.99D);

		ItemErrorException ex = assertThrows(ItemErrorException.class, () -> {
			UnitConversionPricer.unitConversionPriver(item, "OUNCE2", 4);
		});

		assertEquals("The amount's item cannot be negative.", ex.getMessage());

	}

	@Test
	void printUnitConversionWith4Ounce() throws Exception {

		Product product = new Product("beans", "can", WeigthUnit.POUND.toString());
		Item item = new Item(product, 1, 1.99D);

		assertEquals(43.0D, UnitConversionPricer.unitConversionPriver(item, WeigthUnit.OUNCE.toString(), 4));
	}

	@Test
	void printUnitConversionWith5Ounce() throws Exception {

		Product product = new Product("beans", null, WeigthUnit.POUND.toString());
		Item item = new Item(product, 1, 1.99D);

		assertEquals(160.0D, UnitConversionPricer.unitConversionPriver(item, WeigthUnit.OUNCE.toString(), 5));
	}

}
