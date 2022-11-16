package org.ajay.coding;

import org.ajay.coding.facade.ItemDetailsFacade;
import org.ajay.coding.model.ItemDetails;
import org.ajay.coding.utils.FileUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SalesTaxApplication {

    public static void main(String[] args) throws IOException {
        FileUtils fileUtils = new FileUtils();
        InputStream fileFromResource = fileUtils.getFileFromResource("shoppingbaskets/inputThird.txt");

        List<ItemDetails> itemDetailsList = fileUtils.readInputBasketContent(fileFromResource);

        ItemDetailsFacade.printItemDetailsReceipt(itemDetailsList);
    }

}