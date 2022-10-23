package fr.ingeniance.kata.roman;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import fr.ingeniance.kata.roman.exception.NotRomanException;

public class TestRoman {

	@Test
	public void whenExceptionThrown_thenNumberIsNegative() throws Exception {

		NotRomanException ex = assertThrows(NotRomanException.class, () -> {
			Roman.convertToRoman(-1);
		});

		assertEquals("The number input could not be negative.", ex.getMessage());

	}

	@Test
	public void printRomanTest1() throws Exception {
		assertEquals("I", Roman.convertToRoman(1));
	}

	@Test
	public void printRomanTest4() throws Exception {
		assertEquals("IV", Roman.convertToRoman(4));
	}

	@Test
	public void printRomanTest1954() throws Exception {
		assertEquals("MCMLIV", Roman.convertToRoman(1954));
	}

	@Test
	public void printRomanTest1990() throws Exception {
		assertEquals("MCMXC", Roman.convertToRoman(1990));
	}

}
