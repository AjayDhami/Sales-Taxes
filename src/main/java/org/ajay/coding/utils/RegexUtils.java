package org.ajay.coding.utils;

import org.ajay.coding.model.ItemDetails;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {
    private static final String ITEM_INPUT_REGEX = "(\\d+) ([\\w\\s]+ ).*at (\\d+.\\d+)";

    public ItemDetails fetchItemDetails(String input) {
        Pattern pattern = Pattern.compile(ITEM_INPUT_REGEX);
        Matcher matcher = pattern.matcher(input);
        matcher.find();

        String itemQuantity = matcher.group(1);
        String itemDescription = matcher.group(2);
        String itemPrice = matcher.group(3);

        return new ItemDetails(Integer.parseInt(itemQuantity), itemDescription, Double.parseDouble(itemPrice));
    }
}
