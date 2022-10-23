package fr.ingeniance.kata.diamond;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

import fr.ingeniance.kata.diamond.exception.DiamondException;

class TestDiamond {

	@Test
	void whenExceptionThrown_thenLetterIsBad() throws Exception {

		DiamondException ex = assertThrows(DiamondException.class, () -> {
			Diamond.printDiamond("-");
		});

		assertEquals("The letter input is not in a list of alphabet.", ex.getMessage());
	}

	@Test
	void whenExceptionThrown_thenLetterIsEmpty() throws Exception {

		DiamondException ex = assertThrows(DiamondException.class, () -> {
			Diamond.printDiamond("");
		});

		assertEquals("The Letter Cannot be null.", ex.getMessage());

	}

	@Test
	void whenExceptionThrown_thenSizeLetterIsMoreThanOne() throws Exception {

		DiamondException ex = assertThrows(DiamondException.class, () -> {
			Diamond.printDiamond("ab");
		});

		assertEquals("You must write one letter.", ex.getMessage());

	}

	@Test
	void printDiamondTesta() throws Exception {
		assertEquals("a\n", Diamond.printDiamond("a"));
	}

	@Test
	void printDiamondTestb() throws Exception {
		assertEquals("\ta\nb\t\tb\n\ta\n", Diamond.printDiamond("b"));
	}

	@Test
	void printDiamondTestC() throws Exception {
		assertEquals("\t\ta\n\tb\t\tb\nc\t\t\t\tc\n\tb\t\tb\n\t\ta\n", Diamond.printDiamond("C"));
	}
}
