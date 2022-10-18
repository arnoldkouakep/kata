package fr.ingeniance.kata.diamond;

import java.util.Collections;

import fr.ingeniance.kata.diamond.exception.DiamondException;

public class Diamond {

	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxy";

	private Diamond() {
		throw new IllegalStateException("Diamond class");
	}

	/**
	 * This function print diamond from a letter
	 * 
	 * @param letter
	 * @return strDiamond
	 * @throws DiamondException
	 * 
	 */
	public static String printDiamond(CharSequence letter) throws DiamondException {

		int letterPosition = ALPHABET.indexOf(letter.toString().toLowerCase());

		StringBuilder strDiamond = new StringBuilder("");
		controlDiamond(letter);

		for (int i = 0; i < letterPosition + 1; i++) {

			strDiamond.append(repeat(letterPosition - i, "\t")).append(ALPHABET.charAt(i)).append(repeat(i * 2, "\t"))
					.append(i > 0 ? ALPHABET.charAt(i) : "").append("\n");
		}

		for (int i = letterPosition - 1; i >= 0; i--) {

			strDiamond.append(repeat(letterPosition - i, "\t")).append(ALPHABET.charAt(i)).append(repeat(i * 2, "\t"))
					.append(i > 0 ? ALPHABET.charAt(i) : "").append("\n");
		}

		return strDiamond.toString();

	}

	private static void controlDiamond(CharSequence letter) throws DiamondException {

		if (letter == null || letter.toString().isEmpty()) {
			throw new DiamondException("The Letter Cannot be null.");
		} else if (letter.length() > 1) {
			throw new DiamondException("You must write one letter.");
		} else if (!ALPHABET.contains(letter.toString().toLowerCase())) {
			throw new DiamondException("The letter input is not in a list of alphabet.");
		}
	}

	private static String repeat(int nCopie, String text) {
		return String.join("", Collections.nCopies(nCopie, text));
	}
}
