package fr.ingeniance.kata.foobarqix;

import fr.ingeniance.kata.foobarqix.exception.NotFooBarQixException;

public class FooBarQix {

	private static final String[] values = { "Foo", "Bar", "Qix" };

	private FooBarQix() {
		throw new IllegalStateException("FooBarQix class");
	}

	/**
	 * If the number is divisible by 3 or contains 3, replace 3 by "Foo"; if the
	 * number is divisible by 5 or contains 5, replace 5 by "Bar"; if the number is
	 * divisible by 7 or contains 7, replace 7 by "Qix".
	 * 
	 * @param number
	 * @return result
	 * @throws Exception
	 * 
	 */
	public static String printFooBarQix(int number) throws NotFooBarQixException {
		if (number < 0)
			throw new NotFooBarQixException("The number input could not be negative.");

		StringBuilder result = new StringBuilder();

		if (number % 3 == 0)
			result.append(values[0]);
		if (number % 5 == 0)
			result.append(values[1]);
		if (number % 7 == 0)
			result.append(values[2]);

		String numberStr = String.valueOf(number);

		for (int i = 0; i < numberStr.length(); i++) {
			switch (numberStr.charAt(i)) {
			case '3':
				result.append(values[0]);
				break;
			case '5':
				result.append(values[1]);
				break;
			case '7':
				result.append(values[2]);
				break;
			default:
				break;
			}
		}

		return result.toString();
	}
}
