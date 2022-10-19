package fr.ingeniance.kata.threeforonedollarprice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import fr.ingeniance.kata.pricer.data.Item;
import fr.ingeniance.kata.pricer.data.Product;
import fr.ingeniance.kata.pricer.exception.ItemErrorException;
import fr.ingeniance.kata.pricer.exception.ProductNotFoundException;
import fr.ingeniance.kata.pricer.treeforonedollar.ThreeForOneDollarPricer;

class TestThreeForOneDollarPricer {

	@Test
	void whenExceptionThrown_thenProductIsNull() throws Exception {

		Item item = new Item(1L, null, 1, 0.65D);

		ProductNotFoundException ex = assertThrows(ProductNotFoundException.class, () -> {
			ThreeForOneDollarPricer.threeForOneDollar(item, 3);
		});

		assertEquals("The product of item cannot be null.", ex.getMessage());

	}

	@Test
	void whenExceptionThrown_thenItemAmountIsNegative() throws Exception {

		Product product = new Product(1L, "P001", "can", "beans");
		Item item = new Item(1L, product, 1, -0.65D);

		ItemErrorException ex = assertThrows(ItemErrorException.class, () -> {
			ThreeForOneDollarPricer.threeForOneDollar(item, 3);
		});

		assertEquals("The amount's item cannot be negative.", ex.getMessage());

	}

	@Test
	void whenExceptionThrown_thenItemUnityIsNull() throws Exception {

		Product product = new Product(1L, "P001", "can", "beans");
		Item item = new Item(1L, product, null, 1D);

		ItemErrorException ex = assertThrows(ItemErrorException.class, () -> {
			ThreeForOneDollarPricer.threeForOneDollar(item, 3);
		});

		assertEquals("The unity of this item cannot be null.", ex.getMessage());

	}

	@Test
	void whenExceptionThrown_thenItemUnityIsNegative() throws Exception {

		Product product = new Product(1L, "P001", "can", "beans");
		Item item = new Item(1L, product, -1, 1D);

		ItemErrorException ex = assertThrows(ItemErrorException.class, () -> {
			ThreeForOneDollarPricer.threeForOneDollar(item, 3);
		});

		assertEquals("The unity of this item cannot be negative.", ex.getMessage());

	}

	@Test
	void printThreeForOneDollarTestWith4() throws Exception {

		Product product = new Product(1L, "P001", "can", "beans");
		Item item = new Item(1L, product, 3, 1D);

		assertEquals("Total amount : 2.0$", ThreeForOneDollarPricer.threeForOneDollar(item, 4));
	}

	@Test
	void printThreeForOneDollarTestWith5() throws Exception {

		Product product = new Product(1L, "P001", null, "beans");
		Item item = new Item(1L, product, 3, 1D);

		assertEquals("Total amount : 2.0$", ThreeForOneDollarPricer.threeForOneDollar(item, 5));
	}

}
