package org.ajay.coding.utils;

public class MathUtils {

    public double roundSalesTax(double taxAmount) {
        return Math.ceil((taxAmount * 20.0)) / 20.0;
    }

    public double roundPrice(double itemPrice) {
        return Math.round((itemPrice * 100.0)) / 100.0;
    }
}
