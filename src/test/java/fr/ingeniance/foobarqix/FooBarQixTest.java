package fr.ingeniance.foobarqix;

import junit.framework.TestCase;

import static fr.ingeniance.foobarqix.FooBarQix.printFooBarQix;
import static org.junit.Assert.assertThrows;

public class FooBarQixTest extends TestCase {
    public void testFooBarQixWhenNumberIsNegative() {
        Exception ex = assertThrows(Exception.class, () -> printFooBarQix(-1));

        assertEquals("The number input could not be negative.", ex.getMessage());

    }

    public void testFooBarQixWith51() throws Exception {
        assertEquals("FooBar", printFooBarQix(51));
    }

    public void testFooBarQixWith53() throws Exception {
        assertEquals("BarFoo", printFooBarQix(53));
    }

    public void testFooBarQixWith13() throws Exception {
        assertEquals("Foo", printFooBarQix(13));
    }

    public void testFooBarQixWith15() throws Exception {
        assertEquals("FooBarBar", printFooBarQix(15));
    }

    public void testFooBarQixWith33() throws Exception {
        assertEquals("FooFooFoo", printFooBarQix(33));
    }
}