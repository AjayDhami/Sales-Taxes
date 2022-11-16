package org.ajay.coding.utils;

import org.ajay.coding.facade.ItemDetailsFacade;
import org.ajay.coding.model.ItemDetails;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public InputStream getFileFromResource(String fileName) {
        ClassLoader classLoader = this.getClass().getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream(fileName);

        if (resourceAsStream == null) {
            throw new IllegalArgumentException("Shopping Basket input file not found!!! " + fileName);
        } else {
            return resourceAsStream;
        }
    }

    public List<ItemDetails> readInputBasketContent(InputStream inputStream) throws IOException {
        List<ItemDetails> itemDetailsList = new ArrayList<>();

        try (InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String item;
            while ((item = bufferedReader.readLine()) != null) {
                ItemDetailsFacade.fetchItemDetails(itemDetailsList, item);
            }
            inputStream.close();
        }
        return itemDetailsList;
    }
}
