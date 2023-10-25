package fr.ingeniance.diamond;

import junit.framework.TestCase;

import static fr.ingeniance.diamond.Diamond.printDiamond;
import static org.junit.Assert.assertThrows;

public class DiamondTest extends TestCase {

    public void testDiamondWhenLetterIsBad() {

        Exception ex = assertThrows(Exception.class, () -> printDiamond("-"));

        assertEquals("The letter input is not in a list of alphabet.", ex.getMessage());
    }

    public void testDiamondWhenLetterIsEmpty() {

        Exception ex = assertThrows(Exception.class, () -> printDiamond(""));

        assertEquals("The Letter Cannot be null.", ex.getMessage());
    }

    public void testDiamondWhenSizeLetterIsMoreThanOne() {

        Exception ex = assertThrows(Exception.class, () -> printDiamond("ab"));

        assertEquals("You must write one letter.", ex.getMessage());
    }

    public void testDiamondWithA() throws Exception {
        assertEquals("a\n", printDiamond("a"));
    }

    public void testDiamondWithB() throws Exception {
        assertEquals("\ta\nb\t\tb\n\ta\n", printDiamond("b"));
    }

    public void testDiamondWithC() throws Exception {
        assertEquals("\t\ta\n\tb\t\tb\nc\t\t\t\tc\n\tb\t\tb\n\t\ta\n", printDiamond("C"));
    }
}