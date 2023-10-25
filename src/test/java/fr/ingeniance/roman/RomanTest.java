package fr.ingeniance.roman;

import junit.framework.TestCase;

import static fr.ingeniance.roman.Roman.convertToRoman;
import static org.junit.Assert.assertThrows;

public class RomanTest extends TestCase {

    public void testRomanWhenNumberIsNegative() {
        Exception ex = assertThrows(Exception.class, () -> convertToRoman(-1));

        assertEquals("The number input could not be negative.", ex.getMessage());
    }

    public void testRomanWith1() throws Exception {
        assertEquals("I", convertToRoman(1));
    }

    public void testRomanWith4() throws Exception {
        assertEquals("IV", convertToRoman(4));
    }

    public void testRomanWith1954() throws Exception {
        assertEquals("MCMLIV", convertToRoman(1954));
    }

    public void testRomanWith1990() throws Exception {
        assertEquals("MCMXC", convertToRoman(1990));
    }

}