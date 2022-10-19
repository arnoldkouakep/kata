package fr.ingeniance.kata.buytwogetonefree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import fr.ingeniance.kata.pricer.buytwogetonefree.BuyTwoGetOneFree;
import fr.ingeniance.kata.pricer.data.Item;
import fr.ingeniance.kata.pricer.data.Product;
import fr.ingeniance.kata.pricer.enumeration.EnumStatus;
import fr.ingeniance.kata.pricer.exception.ItemErrorException;
import fr.ingeniance.kata.pricer.exception.ProductNotFoundException;
import fr.ingeniance.kata.pricer.unitconversionpricer.UnitConversionPricer;

class TestBuyTwoGetOneFree {

	@Test
	void whenExceptionThrown_thenUnitIsNull() throws Exception {

		Product product = new Product(1L, "P001", "can", "beans");
		Item item = new Item(1L, product, 1, 1D);

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
	void printBuyTwoGetOneFreeWith3() throws Exception {

		Product product = new Product(1L, "P001", "can", "beans");
		Item item = new Item(1L, product, 1, 1D);

		assertEquals("The third costs 0,75$",
				BuyTwoGetOneFree.buyTwoGetOneFree(item, 3));
	}

	@Test
	void printBuyTwoGetOneFreeWith7() throws Exception {

		Product product = new Product(1L, "P001", "can", "beans");
		Item item = new Item(1L, product, 1, 1D);

		assertEquals("The third costs 0,70$",
				BuyTwoGetOneFree.buyTwoGetOneFree(item, 7));
	}

}
