package fr.ingeniance.kata.roman;

import java.util.Collections;

import fr.ingeniance.kata.roman.exception.NotRomanException;

public class Roman {

	private static final int[] NUMERICAL_VALUES = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };

	private static final String[] ROMAN_VALUES = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV",
			"I" };

	private Roman() {
		throw new IllegalStateException("Roman class");
	}

	/**
	 * Convert number to roman letter
	 * 
	 * @param number
	 * @return romanValue
	 */
	public static String convertToRoman(int number) throws NotRomanException {
		if (number < 0)
			throw new NotRomanException("The number input could not be negative.");

		StringBuilder romanValue = new StringBuilder();
		for (int i = 0; i < NUMERICAL_VALUES.length; i++) {
			int nValue = number / NUMERICAL_VALUES[i];
			romanValue.append(String.join("", Collections.nCopies(nValue, ROMAN_VALUES[i])));
			number = number % NUMERICAL_VALUES[i];
		}
		return romanValue.toString();
	}
}
