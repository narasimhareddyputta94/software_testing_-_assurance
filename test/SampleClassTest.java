package assignment;

import assignment.exceptions.InvalidProductException;
import assignment.exceptions.InvalidValueException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SampleClassTest {

    private final SampleClass sampleClass = new SampleClass();

    @Test
    @DisplayName("Test calculateTaxRate with valid product types")
    void testCalculateTaxRateValid() throws InvalidProductException {
        assertEquals(0.05, sampleClass.calculateTaxRate("Bakery"));
        assertEquals(0.075, sampleClass.calculateTaxRate("Beverage"));
        assertEquals(0.04, sampleClass.calculateTaxRate("Dairy"));
        assertEquals(0.04, sampleClass.calculateTaxRate("Produce"));
        assertEquals(0.065, sampleClass.calculateTaxRate("Deli"));
        assertEquals(0.065, sampleClass.calculateTaxRate("Meat"));
        assertEquals(0.06, sampleClass.calculateTaxRate("Seafood"));
    }

    @Test
    @DisplayName("Test calculateTaxRate with invalid product type")
    void testCalculateTaxRateInvalid() {
        assertThrows(InvalidProductException.class, () -> sampleClass.calculateTaxRate("Unknown"));
    }

    @Test
    @DisplayName("Test getDensityQualifier with valid dpi values")
    void testGetDensityQualifierValid() throws InvalidValueException {
        assertEquals("ldpi", sampleClass.getDensityQualifier(120));
        assertEquals("mdpi", sampleClass.getDensityQualifier(160));
        assertEquals("hdpi", sampleClass.getDensityQualifier(240));
        assertEquals("xhdpi", sampleClass.getDensityQualifier(320));
        assertEquals("xxhdpi", sampleClass.getDensityQualifier(480));
        assertEquals("xxxhdpi", sampleClass.getDensityQualifier(640));
        assertEquals("tvdpi", sampleClass.getDensityQualifier(213));
        assertEquals("nodpi", sampleClass.getDensityQualifier(700));
    }

    @Test
    @DisplayName("Test getDensityQualifier with invalid dpi value")
    void testGetDensityQualifierInvalid() {
        assertThrows(InvalidValueException.class, () -> sampleClass.getDensityQualifier(0));
        assertThrows(InvalidValueException.class, () -> sampleClass.getDensityQualifier(-1));
    }
}
