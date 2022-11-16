package org.ajay.coding.facade;

import org.ajay.coding.model.ItemDetails;
import org.ajay.coding.taxCalculator.ItemTaxCalculator;
import org.ajay.coding.utils.MathUtils;
import org.ajay.coding.utils.RegexUtils;

import java.util.List;
import java.util.regex.Pattern;

public class ItemDetailsFacade {
    private static final String TAX_EXEMPT_REGEX = "book|chocolate|pills";
    private static final String ITEM_IMPORTED_REGEX = "imported";

    public static void fetchItemDetails(List<ItemDetails> itemDetailsList, String item) {
        RegexUtils regexUtils = new RegexUtils();
        ItemTaxCalculator itemTaxCalculator = new ItemTaxCalculator();

        ItemDetails itemDetails = regexUtils.fetchItemDetails(item);
        String itemDescription = itemDetails.getDescription();

        setTaxExemptValue(itemDetails, itemDescription);
        setItemImportValue(itemDetails, itemDescription);

        itemTaxCalculator.calculateItemTax(itemDetails);

        itemDetailsList.add(itemDetails);
    }

    private static void setTaxExemptValue(ItemDetails itemDetails, String itemDescription) {
        Pattern taxExemptPattern = Pattern.compile(TAX_EXEMPT_REGEX);
        boolean isItemTaxExempt = taxExemptPattern.matcher(itemDescription).find();
        itemDetails.setExempted(isItemTaxExempt);
    }

    private static void setItemImportValue(ItemDetails itemDetails, String itemDescription) {
        Pattern itemsImportedPattern = Pattern.compile(ITEM_IMPORTED_REGEX);
        boolean isItemImported = itemsImportedPattern.matcher(itemDescription).find();
        itemDetails.setImported(isItemImported);
    }

    public static void printItemDetailsReceipt(List<ItemDetails> itemDetailsList) {
        MathUtils mathUtils = new MathUtils();
        double totalItemSalesTax = 0.0;
        double totalItemPriceAfterTax = 0.0;
        for (ItemDetails itemDetails : itemDetailsList) {
            System.out.println(itemDetails.getQuantity() + " " + itemDetails.getDescription() + ": " + itemDetails.getPriceAfterTax());

            totalItemSalesTax = totalItemSalesTax + itemDetails.getItemSalesTaxes();
            totalItemPriceAfterTax = totalItemPriceAfterTax + itemDetails.getPriceAfterTax();

        }
        System.out.println("Sales Taxes: " + mathUtils.roundPrice(totalItemSalesTax));
        System.out.println("Total: " + mathUtils.roundPrice(totalItemPriceAfterTax));
    }
}
