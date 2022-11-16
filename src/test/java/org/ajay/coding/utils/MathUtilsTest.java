package org.ajay.coding.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    private MathUtils mathUtils;

    @BeforeEach
    public void setUp() {
        mathUtils = new MathUtils();
    }

    @Test
    public void roundSalesTax() {
        double actualRoundSalesTax = mathUtils.roundSalesTax(4.1985);

        assertEquals(4.2, actualRoundSalesTax);
    }

    @Test
    public void roundPrice() {
        double actualRoundPrice = mathUtils.roundPrice(74.677778);

        assertEquals(74.68, actualRoundPrice);
    }
}