package fr.ingeniance.kata.foobarqix;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import fr.ingeniance.kata.foobarqix.exception.NotFooBarQixException;

public class TestFooBarQix {

	@Test
	public void whenExceptionThrown_thenNumberIsNegative() throws Exception {

		NotFooBarQixException ex = assertThrows(NotFooBarQixException.class, () -> {
			FooBarQix.printFooBarQix(-1);
		});

		assertEquals("The number input could not be negative.", ex.getMessage());
	
	}

	@Test
	public void printFooBarQixTest51() throws Exception {
		assertEquals("FooBar", FooBarQix.printFooBarQix(51));
	}

	@Test
	public void printFooBarQixTest53() throws Exception {
		assertEquals("BarFoo", FooBarQix.printFooBarQix(53));
	}

	@Test
	public void printFooBarQixTest13() throws Exception {
		assertEquals("Foo", FooBarQix.printFooBarQix(13));
	}

	@Test
	public void printFooBarQixTes15() throws Exception {
		assertEquals("FooBarBar", FooBarQix.printFooBarQix(15));
	}

	@Test
	public void printFooBarQixTest33() throws Exception {
		assertEquals("FooFooFoo", FooBarQix.printFooBarQix(33));
	}
}
