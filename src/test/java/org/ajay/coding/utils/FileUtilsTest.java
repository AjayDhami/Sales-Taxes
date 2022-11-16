package org.ajay.coding.utils;

import org.ajay.coding.model.ItemDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileUtilsTest {

    private FileUtils fileUtils;

    @BeforeEach
    public void setUp() {
        fileUtils = new FileUtils();
    }

    @Test
    public void getInputStreamForValidFile() {
        InputStream actualFileResource = fileUtils.getInputStreamFromFile("shoppingbaskets/inputThird.txt");

        assertNotNull(actualFileResource);
    }

    @Test
    public void getNullValueForInValidFile() {
        assertThrows(IllegalArgumentException.class,()->{
            fileUtils.getInputStreamFromFile("shoppingbaskets/inputInvalid.txt");
        });
    }

    @Test
    public void readInputBasketContent() throws IOException {
        InputStream inputStream = fileUtils.getInputStreamFromFile("shoppingbaskets/inputThird.txt");
        List<ItemDetails> actualItemDetailsList = fileUtils.readInputBasketContent(inputStream);

        assertNotNull(actualItemDetailsList);
        assertEquals(4,actualItemDetailsList.size());

    }
}