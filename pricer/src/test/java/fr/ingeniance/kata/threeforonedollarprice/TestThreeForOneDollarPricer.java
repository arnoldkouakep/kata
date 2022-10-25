package fr.ingeniance.kata.threeforonedollarprice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import fr.ingeniance.kata.pricer.data.Item;
import fr.ingeniance.kata.pricer.data.Pricer;
import fr.ingeniance.kata.pricer.data.Product;
import fr.ingeniance.kata.pricer.exception.ItemErrorException;
import fr.ingeniance.kata.pricer.exception.ProductNotFoundException;
import fr.ingeniance.kata.pricer.treeforonedollar.ThreeForOneDollarPricer;

public class TestThreeForOneDollarPricer {

	@Test
	public void whenExceptionThrown_thenProductIsNull() throws Exception {

		Item item = new Item(null, 1, 0.65D);

		List<Pricer> pricers = Arrays.asList(new Pricer(item, 3));


		ProductNotFoundException ex = assertThrows(ProductNotFoundException.class, () -> {
			ThreeForOneDollarPricer.threeForOneDollar(pricers);
		});

		assertEquals("The product of item cannot be null.", ex.getMessage());

	}

	@Test
	public void whenExceptionThrown_thenItemAmountIsNegative() throws Exception {

		Product product = new Product("beans", "can");
		Item item = new Item(product, 1, -0.65D);

		List<Pricer> pricers = Arrays.asList(new Pricer(item, 3));


		ItemErrorException ex = assertThrows(ItemErrorException.class, () -> {
			ThreeForOneDollarPricer.threeForOneDollar(pricers);
		});

		assertEquals("The amount's item cannot be negative.", ex.getMessage());

	}

	@Test
	public void whenExceptionThrown_thenItemUnityIsNull() throws Exception {

		Product product = new Product("beans", "can");
		Item item = new Item(product, null, 1D);

		List<Pricer> pricers = Arrays.asList(new Pricer(item, 3));

		ItemErrorException ex = assertThrows(ItemErrorException.class, () -> {
			ThreeForOneDollarPricer.threeForOneDollar(pricers);
		});

		assertEquals("The unity of this item cannot be null.", ex.getMessage());

	}

	@Test
	public void whenExceptionThrown_thenItemUnityIsNegative() throws Exception {

		Product product = new Product("beans", "can");
		Item item = new Item(product, -1, 1D);

		List<Pricer> pricers = Arrays.asList(new Pricer(item, 3));

		ItemErrorException ex = assertThrows(ItemErrorException.class, () -> {
			ThreeForOneDollarPricer.threeForOneDollar(pricers);
		});

		assertEquals("The unity of this item cannot be negative.", ex.getMessage());

	}

	@Test
	public void printThreeForOneDollarTestWith4() throws Exception {

		Product product = new Product("beans", "can");
		Item item = new Item(product, 3, 1D);

		List<Pricer> pricers = Arrays.asList(new Pricer(item, 4));

		
		assertEquals(2.0D, ThreeForOneDollarPricer.threeForOneDollar(pricers), 0D);
	}

	@Test
	public void printThreeForOneDollarTestWith5() throws Exception {

		Product product = new Product("beans", null);
		Item item = new Item(product, 3, 1D);

		List<Pricer> pricers = Arrays.asList(new Pricer(item, 5));

		assertEquals(2.0D, ThreeForOneDollarPricer.threeForOneDollar(pricers), 0D);
	}

}
