package org.ajay.coding.taxCalculator;

import org.ajay.coding.model.ItemDetails;
import org.ajay.coding.utils.MathUtils;

public class ItemTaxCalculator {

    public static void calculateItemTax(ItemDetails itemDetails) {
        double tax = 0.00;
        if (itemDetails.isImported()) {
            tax = tax + 0.05;
        }

        if (!itemDetails.isExempted()) {
            tax = tax + 0.10;
        }

        double itemSalesTaxes = MathUtils.roundSalesTax((itemDetails.getPrice() * tax) * itemDetails.getQuantity());
        double itemTotalPriceAfterTax = MathUtils.roundPrice(itemSalesTaxes + (itemDetails.getQuantity() * itemDetails.getPrice()));

        itemDetails.setItemSalesTaxes(itemSalesTaxes);
        itemDetails.setPriceAfterTax(itemTotalPriceAfterTax);
    }

}
