package org.ajay.coding.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ItemDetails {

    private final int quantity;
    private final String description;
    private final double price;

    private boolean isImported;
    private boolean isExempted;

    private double itemSalesTaxes;
    private double priceAfterTax;

}


