package org.ajay.coding.utils;

import lombok.extern.slf4j.Slf4j;
import org.ajay.coding.service.ItemDetailsService;
import org.ajay.coding.entities.ItemDetails;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FileUtils {

    public InputStream getInputStreamFromFile(String fileName) {
        log.info("Processing the receipt file: {} to get input stream",fileName);
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream(fileName);

        if (resourceAsStream == null) {
            log.error("Shopping Basket input receipt file not found: {}", fileName);
            throw new IllegalArgumentException("Shopping Basket input receipt file not found!!! " + fileName);
        } else {
            return resourceAsStream;
        }
    }

    public List<ItemDetails> readInputBasketContent(InputStream inputStream) throws IOException {
        log.info("Processing file input stream to get item details list");
        List<ItemDetails> itemDetailsList = new ArrayList<>();

        try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String item;
            while ((item = bufferedReader.readLine()) != null) {
                ItemDetailsService.fetchItemDetails(itemDetailsList, item);
            }
            inputStream.close();
        }
        log.info("Total number of items in the receipt file: {}", itemDetailsList.size());
        return itemDetailsList;
    }
}
