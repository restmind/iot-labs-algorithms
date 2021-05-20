package com.shuplat;

import org.junit.Test;

import java.io.IOException;

import static com.shuplat.Wchain.countChains;
import static com.shuplat.Wchain.readDataFromFile;
import static org.junit.Assert.assertEquals;

public class WChainTest {
    @Test
    public void test1() throws IOException {
        String[] inputData = readDataFromFile("input1.in");
        int result = countChains(inputData);
        assertEquals(6, result);
    }

    @Test
    public void test2() throws IOException {
        String[] inputData = readDataFromFile("input2.in");
        int result = countChains(inputData);
        assertEquals(4, result);
    }

    @Test
    public void test3() throws IOException {
        String[] inputData = readDataFromFile("input3.in");
        int result = countChains(inputData);
        assertEquals(1, result);
    }
}
