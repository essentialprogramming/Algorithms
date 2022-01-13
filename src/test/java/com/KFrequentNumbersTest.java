package com;

import com.essentialprogramming.algorithms.KFrequentNumbers;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class KFrequentNumbersTest {

    @Test
    public void successfullyTestV1() {

        //given
        int[] arr = {2, 1, 3, 3, 5, 5, 5, 2, 6, 1};
        int k = 3;
        HashMap<Integer, Long> expectedResult = new HashMap<>();

        expectedResult.put(5, 3L);
        expectedResult.put(3, 2L);
        expectedResult.put(2, 2L);
        expectedResult.put(1, 2L);
        expectedResult.put(6, 1L);

        List<Map.Entry<Integer, Long>> list = new ArrayList<>(expectedResult.entrySet());

        list.sort((a, b) -> {
            if (a.getValue().equals(b.getValue()))
                return b.getKey() - a.getKey();
            else
                return (int) (b.getValue() - a.getValue());
        });

        //when
        Collection<Map.Entry<Integer, Long>> result = KFrequentNumbers.K_mostFrequentNumberV1(arr, k);

        //then
        assertIterableEquals(list, result);
    }

    @Test
    public void successfullyTestV2() {

        //given
        int[] arr = {2, 1, 3, 3, 5, 5, 5, 2, 6, 1};
        int k = 3;
        HashMap<Integer, Long> expectedResult = new HashMap<>();

        expectedResult.put(5, 3L);
        expectedResult.put(3, 2L);
        expectedResult.put(2, 2L);
        expectedResult.put(1, 2L);
        expectedResult.put(6, 1L);

        PriorityQueue<Map.Entry<Integer, Long>> list = new PriorityQueue<>((a, b) -> a.getValue().equals(b.getValue())
                ? Integer.compare(b.getKey(), a.getKey())
                : Long.compare(b.getValue(), a.getValue()));

        list.addAll(expectedResult.entrySet());

        //when
        Collection<Map.Entry<Integer, Long>> result = KFrequentNumbers.K_mostFrequentNumberV2(arr, k);

        //then
        assertIterableEquals(list, result);
    }
}
