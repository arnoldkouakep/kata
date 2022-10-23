package fr.ingeniance.kata.simpleprice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import fr.ingeniance.kata.pricer.data.Item;
import fr.ingeniance.kata.pricer.data.Product;
import fr.ingeniance.kata.pricer.exception.ProductNotFoundException;
import fr.ingeniance.kata.pricer.simple.SimplePricer;

class TestSimplePricer {

	@Test
	void whenExceptionThrown_thenProductIsNull() throws Exception {

		Item item = new Item(null, 1, 0.65D);

		ProductNotFoundException ex = assertThrows(ProductNotFoundException.class, () -> {
			SimplePricer.simplePriceOfProduct(item);
		});

		assertEquals("The product of item cannot be null.", ex.getMessage());

	}

	@Test
	void whenExceptionThrown_thenItemAmountIsNegative() throws Exception {

		Product product = new Product("beans", "can");
		final Item item = new Item(product, 1, -0.65D);

		ProductNotFoundException ex = assertThrows(ProductNotFoundException.class, () -> {
			SimplePricer.simplePriceOfProduct(item);
		});

		assertEquals("The amount's item cannot be negative.", ex.getMessage());

	}

	@Test
	void printSimplePriceTest1() throws Exception {

		Product product = new Product("can", "beans");
		Item item = new Item(product, 1, 0.65D);

		assertEquals("This can of beans costs 0.65$", SimplePricer.simplePriceOfProduct(item));
	}

	@Test
	void printSimplePriceTest2() throws Exception {

		Product product = new Product("beans", null);
		Item item = new Item(product, 1, 0.65D);

		assertEquals("This beans costs 0.65$", SimplePricer.simplePriceOfProduct(item));
	}

}
