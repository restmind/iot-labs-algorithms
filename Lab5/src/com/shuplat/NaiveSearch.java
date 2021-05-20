package com.shuplat;

import java.util.ArrayList;
import java.util.List;

public class NaiveSearch {
    public static List<Integer> naiveSearch(String inputText, String substring) {
        List<Integer> result = new ArrayList<>();
        for (int startPoint = 0; startPoint < inputText.length() - substring.length() + 1; startPoint++) {
            int countMatches = 0;
            for (; countMatches < substring.length(); countMatches++) {
                if (inputText.charAt(startPoint + countMatches) != substring.charAt(countMatches)) {
                    break;
                }
            }
            if (countMatches == substring.length()) {
                result.add(startPoint);
                System.out.println("Substring in starts at :" + startPoint);
            }
        }
        return result;
    }

}

