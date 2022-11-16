package org.ajay.coding.service;

import lombok.extern.slf4j.Slf4j;
import org.ajay.coding.entities.ItemDetails;
import org.ajay.coding.utils.MathUtils;
import org.ajay.coding.utils.RegexUtils;

import java.util.List;
import java.util.regex.Pattern;

@Slf4j
public class ItemDetailsService {
    private static final String TAX_EXEMPT_REGEX = "book|chocolate|pills";
    private static final String ITEM_IMPORTED_REGEX = "imported";

    public static void fetchItemDetails(List<ItemDetails> itemDetailsList, String item) {
        log.info("Fetching details for the item: {}", item);

        RegexUtils regexUtils = new RegexUtils();
        ItemTaxCalculatorService itemTaxCalculatorService = new ItemTaxCalculatorService();

        ItemDetails itemDetails = regexUtils.fetchItemDetails(item);
        String itemDescription = itemDetails.getDescription();

        setTaxExemptedValue(itemDetails, itemDescription);
        setItemImportedValue(itemDetails, itemDescription);

        itemTaxCalculatorService.calculateItemTax(itemDetails);

        log.info("Processed Item Details: {}", itemDetails);
        itemDetailsList.add(itemDetails);
    }

    private static void setTaxExemptedValue(ItemDetails itemDetails, String itemDescription) {
        log.info("Setting Tax Exempted Value for the item");
        Pattern taxExemptPattern = Pattern.compile(TAX_EXEMPT_REGEX);
        boolean isItemTaxExempt = taxExemptPattern.matcher(itemDescription).find();
        itemDetails.setExempted(isItemTaxExempt);
    }

    private static void setItemImportedValue(ItemDetails itemDetails, String itemDescription) {
        log.info("Setting Item Imported Value for the item");
        Pattern itemsImportedPattern = Pattern.compile(ITEM_IMPORTED_REGEX);
        boolean isItemImported = itemsImportedPattern.matcher(itemDescription).find();
        itemDetails.setImported(isItemImported);
    }

    public static void printItemDetailsReceipt(List<ItemDetails> itemDetailsList) {
        log.info("Displaying final receipt details including tax for {} items.", itemDetailsList.size());
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
