package org.ajay.coding.taxCalculator;

import org.ajay.coding.model.ItemDetails;
import org.ajay.coding.utils.MathUtils;

public class ItemTaxCalculator {

    public void calculateItemTax(ItemDetails itemDetails) {
        MathUtils mathUtils = new MathUtils();

        double tax = 0.00;
        if (itemDetails.isImported()) {
            tax = tax + 0.05;
        }

        if (!itemDetails.isExempted()) {
            tax = tax + 0.10;
        }

        double itemSalesTaxes = mathUtils.roundSalesTax((itemDetails.getPrice() * tax) * itemDetails.getQuantity());
        double itemTotalPriceAfterTax = mathUtils.roundPrice(itemSalesTaxes + (itemDetails.getQuantity() * itemDetails.getPrice()));

        itemDetails.setItemSalesTaxes(itemSalesTaxes);
        itemDetails.setPriceAfterTax(itemTotalPriceAfterTax);
    }

}
