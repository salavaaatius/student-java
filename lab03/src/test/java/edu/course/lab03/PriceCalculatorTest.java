
package edu.course.lab03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PriceCalculatorTest {

    @Test
    void noDiscountReturnsOriginalPrice() {
        PriceCalculator calculator =
                new PriceCalculator(new NoDiscount());

        assertEquals(100, calculator.calculate(100));
    }

    @Test
    void noDiscountRejectsNegativePrice() {
        NoDiscount policy = new NoDiscount();

        assertThrows(IllegalArgumentException.class,
                () -> policy.apply(-100));
    }

    @Test
    void percentDiscountReducesPrice() {
        PriceCalculator calculator =
                new PriceCalculator(new PercentDiscount(20));

        assertEquals(80, calculator.calculate(100), 0.0001);
    }

    @Test
    void percentDiscountSupportsBoundaryValues() {
        PercentDiscount noDiscount = new PercentDiscount(0);
        PercentDiscount fullDiscount = new PercentDiscount(100);

        assertEquals(100, noDiscount.apply(100));
        assertEquals(0, fullDiscount.apply(100));
    }

    @Test
    void percentDiscountRejectsInvalidPercentage() {
        assertThrows(IllegalArgumentException.class,
                () -> new PercentDiscount(-10));

        assertThrows(IllegalArgumentException.class,
                () -> new PercentDiscount(110));
    }

    @Test
    void percentDiscountRejectsNegativePrice() {
        PercentDiscount policy = new PercentDiscount(20);

        assertThrows(IllegalArgumentException.class,
                () -> policy.apply(-100));
    }

    @Test
    void calculatorCanUseDifferentPolicies() {
        PriceCalculator withoutDiscount =
                new PriceCalculator(new NoDiscount());

        PriceCalculator withDiscount =
                new PriceCalculator(new PercentDiscount(20));

        assertEquals(100, withoutDiscount.calculate(100));
        assertEquals(80, withDiscount.calculate(100));
    }

    @Test
    void rejectsNullPolicy() {
        assertThrows(IllegalArgumentException.class,
                () -> new PriceCalculator(null));
    }
}
