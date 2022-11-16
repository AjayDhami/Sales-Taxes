package org.ajay.coding.utils;

import org.ajay.coding.entities.ItemDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class RegexUtilsTest {

    private RegexUtils regexUtils;

    @BeforeEach
    public void setUp() {
        regexUtils = new RegexUtils();
    }

    @Test
    public void fetchItemDetails() {
        ItemDetails actualItemDetails = regexUtils.fetchItemDetails("1 imported bottle of perfume at 27.99");

        assertEquals(1, actualItemDetails.getQuantity());
        assertEquals("imported bottle of perfume ", actualItemDetails.getDescription());
        assertEquals(27.99, actualItemDetails.getPrice());

    }
}