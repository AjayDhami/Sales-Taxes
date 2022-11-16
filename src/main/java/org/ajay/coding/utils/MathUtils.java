package org.ajay.coding.utils;

public class MathUtils {

    public static double roundSalesTax(double taxAmount) {
        return Math.ceil((taxAmount * 20.0)) / 20.0;
    }

    public static double roundPrice(double itemPrice) {
        return Math.round((itemPrice * 100.0)) / 100.0;
    }
}
