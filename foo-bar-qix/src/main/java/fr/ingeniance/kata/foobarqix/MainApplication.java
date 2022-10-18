package fr.ingeniance.kata.foobarqix;

import java.util.logging.Level;
import java.util.logging.Logger;

import fr.ingeniance.kata.foobarqix.exception.NotFooBarQixException;

public class MainApplication {

	private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public static void main(String[] args) {
		print(1990);

		print(999);

	}

	public static void print(final int number) {
		logger.log(Level.INFO, () -> {
			try {
				return FooBarQix.printFooBarQix(number);
			} catch (NotFooBarQixException e) {
				logger.log(Level.SEVERE, e.getMessage());
				e.printStackTrace();
			}
			return null;
		});
	}
}
