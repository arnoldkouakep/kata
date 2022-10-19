package fr.ingeniance.kata.unitConverti;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import fr.ingeniance.kata.pricer.data.Item;
import fr.ingeniance.kata.pricer.data.Product;
import fr.ingeniance.kata.pricer.enumeration.EnumStatus;
import fr.ingeniance.kata.pricer.exception.ItemErrorException;
import fr.ingeniance.kata.pricer.exception.ProductNotFoundException;
import fr.ingeniance.kata.pricer.unitconversionpricer.UnitConversionPricer;

class TestUnitConversionPricer {

	@Test
	void whenExceptionThrown_thenUnitIsNull() throws Exception {

		Product product = new Product(1L, "P001", "can", "beans", EnumStatus.POUND.toString());
		Item item = new Item(1L, product, 1, 1.99D);

		ProductNotFoundException ex = assertThrows(ProductNotFoundException.class, () -> {
			UnitConversionPricer.unitConversionPriver(item, null, 1);
		});

		assertEquals("The unit conversion of this item or product cannot be null.", ex.getMessage());

	}

	@Test
	void whenExceptionThrown_thenUnitNotInRanger() throws Exception {

		Product product = new Product(1L, "P001", "can", "bean", EnumStatus.POUND.toString());
		Item item = new Item(1L, product, 1, 1.99D);

		ItemErrorException ex = assertThrows(ItemErrorException.class, () -> {
			UnitConversionPricer.unitConversionPriver(item, "OUNCE2", 4);
		});

		assertEquals("The amount's item cannot be negative.", ex.getMessage());

	}

	@Test
	void printUnitConversionWith4Ounce() throws Exception {

		Product product = new Product(1L, "P001", "can", "beans", EnumStatus.POUND.toString());
		Item item = new Item(1L, product, 1, 1.99D);

		assertEquals("Total amount : 43.0$",
				UnitConversionPricer.unitConversionPriver(item, EnumStatus.OUNCE.toString(), 4));
	}

	@Test
	void printUnitConversionWith5Ounce() throws Exception {

		Product product = new Product(1L, "P001", null, "beans", EnumStatus.POUND.toString());
		Item item = new Item(1L, product, 1, 1.99D);

		assertEquals("Total amount : 160.0$", UnitConversionPricer.unitConversionPriver(item, EnumStatus.OUNCE.toString(), 5));
	}

}
