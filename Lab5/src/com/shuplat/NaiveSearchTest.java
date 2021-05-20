package com.shuplat;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.shuplat.NaiveSearch.naiveSearch;
import static org.junit.Assert.assertEquals;

public class NaiveSearchTest {
    @Test
    public void test1() {
        String text = "AABAACAADAABAAABAA";
        String substring = "AABA";
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(9);
        expected.add(13);
        assertEquals(expected, naiveSearch(text, substring));
    }

    @Test
    public void test2() {
        String text = "hellohellohello";
        String substring = "hello";
        List<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(5);
        expected.add(10);
        assertEquals(expected, naiveSearch(text, substring));
    }

    @Test
    public void test3() {
        String text = "cnvdsndspnfdovnfdoivnfdoivndfoivnfodnvofinoqwerty";
        String substring = "qwerty";
        List<Integer> expected = new ArrayList<>();
        expected.add(43);
        assertEquals(expected, naiveSearch(text, substring));
    }

    @Test
    public void test4() {
        String text = "cnvdsndspnfdovnfdoivnfdoivndfoivnfodnvofinoqwerty";
        String substring = "Howard";
        List<Integer> expected = new ArrayList<>();
        assertEquals(expected, naiveSearch(text, substring));
    }
}
