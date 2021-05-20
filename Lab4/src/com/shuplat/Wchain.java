package com.shuplat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Integer.max;
import static java.lang.Integer.parseInt;

public class Wchain {

    public static int countChains(String[] words) {
        int result = 0;
        Map<String, Integer> wordChain = new LinkedHashMap<>();
        for (int iterator = 0; iterator < words.length; iterator++) {
            wordChain.put(words[iterator], 1);
        }
        for (String word : wordChain.keySet()) {
            if (word.length() == 1) {
                continue;
            }
            for (int iterator = 0; iterator < word.length(); iterator++) {
                StringBuilder sb = new StringBuilder(word);
                String wordToСheck = sb.deleteCharAt(iterator).toString();
                if (wordChain.containsKey(wordToСheck)) {
                    wordChain.put(word, max(wordChain.get(wordToСheck) + 1, wordChain.get(word)));
                }
            }
        }
        result = wordChain.values().stream().max(Integer::compare).get();
        return result;
    }

    public static String[] readDataFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(
                "src/com/shuplat/inputs/" + fileName));
        String line;
        int index = 0;
        int quantityOfLines = parseInt(reader.readLine());
        String[] input = new String[quantityOfLines];
        while ((line = reader.readLine()) != null) {
            Scanner scanner = new Scanner(line);
            scanner.useDelimiter(",");
            input[index++] = scanner.next();
        }
        reader.close();
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = i + 1; j < input.length; j++) {
                if (input[i].length() > input[j].length()) {
                    String temp = input[i];
                    input[i] = input[j];
                    input[j] = temp;
                }
            }
        }
        return input;
    }
}
