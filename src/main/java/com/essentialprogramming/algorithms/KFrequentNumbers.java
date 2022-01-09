package com.essentialprogramming.algorithms;

// Find k elements with max occurrence.

import java.util.*;
import java.util.stream.Collectors;

public class KFrequentNumbers {

    static void print_K_mostFrequentNumber(int[] arr, int k) {

        //Create a HashMap to store element-frequency pair.
        //final Map<Integer, Long> frequencyMap =  Arrays.stream(arr).boxed().collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        final Map<Integer, Long> frequencyMap = new HashMap<>();

        for (int element : arr) {
            //frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
            frequencyMap.putIfAbsent(element, 1L);
            frequencyMap.computeIfPresent(element, (key, val) -> {
                val = val + 1;
                return val;
            });
        }


        // Create a list from elements of HashMap
        List<Map.Entry<Integer, Long>> list = new ArrayList<>(frequencyMap.entrySet());

        // Sort the list
        list.sort((o1, o2) -> {
            if (o1.getValue().equals(o2.getValue()))
                return o2.getKey() - o1.getKey();
            else
                return (int) (o2.getValue() - o1.getValue());
        });

        for (int i = 0; i < k; i++)
            System.out.println(list.get(i).getKey());
    }


    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 3, 5, 5, 5, 2, 6, 1};
        int k = 3;

        // Function call
        print_K_mostFrequentNumber(arr, k);
    }
}
