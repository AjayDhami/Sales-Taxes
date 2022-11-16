package org.ajay.coding.taxCalculator;

import org.ajay.coding.model.ItemDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTaxCalculatorTest {
    private ItemTaxCalculator itemTaxCalculator;

    @BeforeEach
    public void setUp() {
        itemTaxCalculator = new ItemTaxCalculator();
    }

    @Test
    public void calculateItemTax() {
        ItemDetails itemDetails = ItemDetails.builder()
                .quantity(1)
                .description("imported bottle of perfume ")
                .price(27.99)
                .isExempted(false)
                .isImported(true)
                .build();

        itemTaxCalculator.calculateItemTax(itemDetails);

        assertEquals(4.2, itemDetails.getItemSalesTaxes());
        assertEquals(32.19, itemDetails.getPriceAfterTax());
    }
}