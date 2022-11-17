package org.ajay.coding;


import lombok.extern.slf4j.Slf4j;
import org.ajay.coding.service.ItemDetailsService;
import org.ajay.coding.entities.ItemDetails;
import org.ajay.coding.utils.FileUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Slf4j
public class SalesTaxApplication {

    public static void main(String[] args) throws IOException {
        log.info("Sales Tax Application started");

        String inputFile = args.length == 1 ? args[0] : "shoppingbaskets/inputFirst.txt";
        log.info("Input Receipt File: {}",inputFile);

        FileUtils fileUtils = new FileUtils();
        InputStream fileFromResource = fileUtils.getInputStreamFromFile(inputFile);

        List<ItemDetails> itemDetailsList = fileUtils.readInputBasketContent(fileFromResource);

        ItemDetailsService.printItemDetailsReceipt(itemDetailsList);
    }

}