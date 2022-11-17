package org.ajay.coding.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
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


