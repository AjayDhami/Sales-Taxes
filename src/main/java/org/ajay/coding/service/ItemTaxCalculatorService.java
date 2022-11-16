package org.ajay.coding.service;

import lombok.extern.slf4j.Slf4j;
import org.ajay.coding.entities.ItemDetails;
import org.ajay.coding.utils.MathUtils;

@Slf4j
public class ItemTaxCalculatorService {

    public void calculateItemTax(ItemDetails itemDetails) {
        log.info("Calculating tax applicable to the item");
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
