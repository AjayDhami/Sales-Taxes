package org.ajay.coding.service;

import org.ajay.coding.entities.ItemDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTaxCalculatorServiceTest {
    private ItemTaxCalculatorService itemTaxCalculatorService;

    @BeforeEach
    public void setUp() {
        itemTaxCalculatorService = new ItemTaxCalculatorService();
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

        itemTaxCalculatorService.calculateItemTax(itemDetails);

        assertEquals(4.2, itemDetails.getItemSalesTaxes());
        assertEquals(32.19, itemDetails.getPriceAfterTax());
    }
}