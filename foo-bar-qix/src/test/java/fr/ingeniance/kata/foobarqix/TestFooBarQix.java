package fr.ingeniance.kata.foobarqix;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import fr.ingeniance.kata.foobarqix.exception.NotFooBarQixException;

class TestFooBarQix {

	@Test
	void whenExceptionThrown_thenNumberIsNegative() throws Exception {

		NotFooBarQixException ex = assertThrows(NotFooBarQixException.class, () -> {
			FooBarQix.printFooBarQix(-1);
		});

		assertEquals("The number input could not be negative.", ex.getMessage());
	
	}

	@Test
	void printFooBarQixTest51() throws Exception {
		assertEquals("FooBar", FooBarQix.printFooBarQix(51));
	}

	@Test
	void printFooBarQixTest53() throws Exception {
		assertEquals("BarFoo", FooBarQix.printFooBarQix(53));
	}

	@Test
	void printFooBarQixTest13() throws Exception {
		assertEquals("Foo", FooBarQix.printFooBarQix(13));
	}

	@Test
	void printFooBarQixTes15() throws Exception {
		assertEquals("FooBarBar", FooBarQix.printFooBarQix(15));
	}

	@Test
	void printFooBarQixTest33() throws Exception {
		assertEquals("FooFooFoo", FooBarQix.printFooBarQix(33));
	}
}
