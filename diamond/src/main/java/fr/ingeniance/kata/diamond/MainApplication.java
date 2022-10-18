package fr.ingeniance.kata.diamond;

import java.util.logging.Level;
import java.util.logging.Logger;

import fr.ingeniance.kata.diamond.exception.DiamondException;

public class MainApplication {
	private static final Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	public static void main(String[] args) {
		printDiamond("");

		printDiamond("-");

		printDiamond("ab");

		printDiamond("a");

		printDiamond("c");

		printDiamond("g");
	}

	public static void printDiamond(String text) {
		logger.log(Level.INFO, () -> {
			try {
				return Diamond.printDiamond(text);
			} catch (DiamondException e) {
				logger.log(Level.SEVERE, e.getMessage());
				e.printStackTrace();
			}
			return null;
		});
	}
}
