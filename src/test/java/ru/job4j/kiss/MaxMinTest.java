package ru.job4j.kiss;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MaxMinTest {
    @Test
    public void whenCallMaxThenGetMax() {
        List<Integer> abc = List.of(11, 2, 31, 4, 15, 6, 7);
        MaxMin maxMin = new MaxMin();
        int result = maxMin.max(abc, Integer::compareTo);
        assertEquals(31, result);
    }

    @Test
    public void whenCallMinThenGetMin() {
        List<Integer> abc = List.of(11, 2, 31, 4, 15, 6, 7);
        MaxMin maxMin = new MaxMin();
        int result = maxMin.min(abc, Integer::compareTo);
        assertEquals(2, result);
    }
}
