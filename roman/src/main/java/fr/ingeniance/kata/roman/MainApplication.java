package fr.ingeniance.kata.roman;

import java.util.logging.Level;
import java.util.logging.Logger;

import fr.ingeniance.kata.roman.exception.NotRomanException;

public class MainApplication {

	private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public static void main(String[] args) {
		print(1990);

		print(999);

	}

	public static void print(final int number) {
		logger.log(Level.INFO, () -> {
			try {
				return Roman.convertToRoman(number);
			} catch (NotRomanException e) {
				logger.log(Level.SEVERE, e.getMessage());
				e.printStackTrace();
			}
			return null;
		});
	}
}
